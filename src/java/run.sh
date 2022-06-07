mkdir -p core plugin
rsync -q $(find crawler -name '*.jar') core
rsync -q $(find core -name 'http-*.jar') --remove-source-files plugin

java -p core -m com.company.crawler.main/com.company.crawler.main.Main plugin
