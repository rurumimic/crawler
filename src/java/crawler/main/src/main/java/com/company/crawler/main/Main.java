package com.company.crawler.main;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.lang.module.ModuleReference;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.company.crawler.api.Request;

public class Main {
    public static void main(String[] args) {
        // if (args.length < 1) {
        //     System.out.println("Input module directories");
        //     return;
        // }

        System.out.println("Hello world!");

        load_plugins(args);

        System.out.println("Terminate.");
    }

    private static void load_plugins(String[] locations) {
        System.out.println("Loading plugin from " + Arrays.toString(locations));
        Stream<ModuleLayer> pluginLayers = Stream.of(locations).map(Main::createPluginLayer);

        pluginLayers
            .flatMap(layer -> toStream(ServiceLoader.load(layer, Request.class)))
            .forEach(request -> {
                String result = request.get("https://www.google.com");
                System.out.println("Service: " + request.getName());
                System.out.println(result);
            });
    }

    private static ModuleLayer createPluginLayer(String location) {
        ModuleFinder finder = ModuleFinder.of(Paths.get(location));
        Set<ModuleReference> refs = finder.findAll();
        Set<String> roots = refs.stream()
            .map(ref -> ref.descriptor().name())
            .collect(Collectors.toSet());

        ModuleLayer parent = ModuleLayer.boot();
        Configuration config = parent.configuration().resolve(finder, ModuleFinder.of(), roots);

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        return parent.defineModulesWithOneLoader(config, classLoader);
    }

    static <T> Stream<T> toStream(Iterable<T> iterable) {
        return StreamSupport.stream(iterable.spliterator(), false);
    }

}
