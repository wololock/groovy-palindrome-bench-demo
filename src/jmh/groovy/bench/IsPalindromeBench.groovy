package bench

import groovy.transform.CompileStatic
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State

import java.util.Map.Entry

@State(Scope.Benchmark)
class IsPalindromeBench {

    static final Random random = new Random()

    static final List<Entry<String, Boolean>> input = [
            "20200202": true,
            "kayak": true,
            "saippuakivikauppias": true,
            "wepanicinapew": true,
            "saippuakuppinippukauppias": true,
            "satanoscillatemymetallicsonatas": true,
            "tattarrattat": true,
            "aa": true,
            "aba": true,
            "daad": true,
            "a": true,
            "baba": false,
            "loremipsumdolorsitamet": false
    ].entrySet().toList()

    @Benchmark
    void a_reverse_dynamic() {
        for (int i = 0; i < 1000; i++) {
            final Entry<String,Boolean> entry = input.get(random.nextInt(input.size()))

            assert isPalindromeReverseDynamic(entry.key) == entry.value
        }
    }

    @Benchmark
    @CompileStatic
    void a_reverse_static() {
        for (int i = 0; i < 1000; i++) {
            final Entry<String,Boolean> entry = input.get(random.nextInt(input.size()))

            assert isPalindromeReverseStatic(entry.key) == entry.value
        }
    }

    @Benchmark
    void b_imperative_dynamic() {
        for (int i = 0; i < 1000; i++) {
            final Entry<String,Boolean> entry = input.get(random.nextInt(input.size()))

            assert isPalindromeImperativeDynamic(entry.key) == entry.value
        }
    }

    @Benchmark
    @CompileStatic
    void b_imperative_static() {
        for (int i = 0; i < 1000; i++) {
            final Entry<String,Boolean> entry = input.get(random.nextInt(input.size()))

            assert isPalindromeImperativeStatic(entry.key) == entry.value
        }
    }

    static boolean isPalindromeReverseDynamic(final String str) {
        return str == str.reverse()
    }

    @CompileStatic
    static boolean isPalindromeReverseStatic(final String str) {
        return str == str.reverse()
    }

    static boolean isPalindromeImperativeDynamic(final String str) {
        int m = str.size() - 1
        int n = Math.floorDiv(m, 2)
        char[] chars = str.toCharArray()

        for (int i = 0; i < n; i++) {
            if (chars[i] != chars[m - i]) {
                return false
            }
        }
        return true
    }

    @CompileStatic
    static boolean isPalindromeImperativeStatic(final String str) {
        int m = str.size() - 1
        int n = Math.floorDiv(m, 2)
        char[] chars = str.toCharArray()

        for (int i = 0; i < n; i++) {
            if (chars[i] != chars[m - i]) {
                return false
            }
        }
        return true
    }
}
