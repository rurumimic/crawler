# Crawler

## Usage

### Compile

```bash
mvn install
```

```bash
cd src/java
mkdir -p core plugin
rsync -q $(find crawler -name '*.jar') core
rsync -q $(find core -name 'http-*.jar') --remove-source-files plugin
```

### Run

```bash
java -p core -m com.company.crawler.main/com.company.crawler.main.Main plugin
```

```bash
Hello world!
Loading plugin from [plugin]
Service: HttpRequest
HTTP Request: https://www.google.com
Terminate.
```

#### with Maven

```bash
cd main
mvn exec:exec
```

```bash
Hello world!
Loading plugin from []
Terminate.
```
