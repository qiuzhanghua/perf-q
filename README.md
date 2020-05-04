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
### Redis(6.0)
```text
➜  ~ wrk -t12 -c100 -d30s http://localhost:8080/hello
Running 30s test @ http://localhost:8080/hello
  12 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.47ms  217.42us   5.70ms   73.11%
    Req/Sec     5.45k   434.11     7.26k    70.71%
  1958701 requests in 30.10s, 171.85MB read
Requests/sec:  65072.61
```
## See also
<https://quarkus.io/guides/getting-started-reactive>