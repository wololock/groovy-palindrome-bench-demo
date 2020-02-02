# Groovy `isPalindrome` benchmark demo

Run the benchmark with:

```
./gradlew --no-daemon jmh
```

Here are results from my laptop:

```
# Run complete. Total time: 00:04:42

REMEMBER: The numbers below are just data. To gain reusable insights, you need to follow up on
why the numbers are the way they are. Use profilers (see -prof, -lprof), design factorial
experiments, perform baseline and negative tests that provide experimental control, make sure
the benchmarking environment is safe on JVM/OS/HW level, ask for reviews from the domain experts.
Do not assume the numbers tell you what you want them to tell.

Benchmark                               Mode  Cnt  Score   Error  Units
IsPalindromeBench.a_reverse_dynamic     avgt   40  0,166 ± 0,002  ms/op
IsPalindromeBench.a_reverse_static      avgt   40  0,139 ± 0,003  ms/op
IsPalindromeBench.b_imperative_dynamic  avgt   40  0,155 ± 0,003  ms/op
IsPalindromeBench.b_imperative_static   avgt   40  0,111 ± 0,002  ms/op

```



