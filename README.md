# perf-q project

## Running the application in dev mode
```
gradle quarkusDev
```

## Packaging and running the application
```bash
gradle quarkusBuild
```
```bash
java -jar build/perf-q-1.0-SNAPSHOT-runner.jar
```
```bash
gradle quarkusBuild --uber-jar
```

## Creating a native executable
```bash
gradle buildNative
```

### Performance
```text
➜  ~ wrk -t12 -c100 -d30s http://localhost:8080/hello
Running 30s test @ http://localhost:8080/hello
  12 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     3.55ms    1.40ms  51.50ms   96.27%
    Req/Sec     2.29k   491.48    18.44k    72.62%
  819532 requests in 30.10s, 64.87MB read
Requests/sec:  27227.83
Transfer/sec:      2.16MB
```

## See also
<https://quarkus.io/guides/getting-started-reactive>