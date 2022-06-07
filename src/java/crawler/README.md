# Crawler

## Usage

### Compile

```bash
mvn install
```

```bash
cd src/java
mkdir -p mods
rsync -q $(find crawler -name '*.jar') mods
```

### Run

```bash
java -p mods -m com.company.crawler.main/com.company.crawler.main.Main
```

```bash
Hello world!
Service: HttpRequest
HTTP Request: https://www.google.com
Terminate.
```

#### with Maven

```bash
cd main
mvn exec:exec
```
