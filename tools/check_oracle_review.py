"""Verify restored starter integrity and the new Oracle revision examples."""
from pathlib import Path
import hashlib
import json
import subprocess
import tempfile

ROOT = Path(__file__).resolve().parents[1]

HARNESS = r'''
import java.util.Arrays;
import java.util.Collections;

public class OracleReviewCheck {
    static void eq(Object actual, Object expected) {
        if (!expected.equals(actual)) throw new AssertionError(actual + " != " + expected);
    }
    public static void main(String[] args) {
        double[] limits = {380, 450, 495, 570, 590, 620, 750};
        String[] colours = {"Violet", "Blue", "Green", "Yellow", "Orange", "Red", "Outside spectrum"};
        for (int i = 0; i < limits.length; i++) {
            eq(DecisionRules.colour(limits[i]), colours[i]);
            eq(DecisionRules.colour(Math.nextUp(limits[i])), colours[i]);
            eq(DecisionRules.colour(Math.nextDown(limits[i])), i == 0 ? "Outside spectrum" : colours[i - 1]);
        }
        eq(DecisionRules.colour(Double.NaN), "Outside spectrum");
        eq(DecisionRules.colour(Double.POSITIVE_INFINITY), "Outside spectrum");
        eq(DecisionRules.colour(Double.NEGATIVE_INFINITY), "Outside spectrum");
        String[] lights = {"Invalid colour", "Green", "Yellow", "Red", "Invalid colour"};
        for (int i = 0; i < lights.length; i++) {
            eq(DecisionRules.nextLightIf(i), lights[i]);
            eq(DecisionRules.nextLightSwitch(i), lights[i]);
        }
        eq(DecisionRules.nextLightIf(-1), "Invalid colour");
        eq(DecisionRules.nextLightSwitch(-1), "Invalid colour");
        int[] ages = {0, 10, 11, 12, 64, 65, 100};
        int[] fares = {3, 3, 3, 5, 5, 3, 3};
        for (int i = 0; i < ages.length; i++) eq(DecisionRules.fare(ages[i]), fares[i]);
        try { DecisionRules.fare(-1); throw new AssertionError("Negative age accepted"); }
        catch (IllegalArgumentException expected) { }
        eq(DecisionRules.shouldWatch(11.99, 5), false);
        eq(DecisionRules.shouldWatch(12, 5), true);
        eq(DecisionRules.shouldWatch(12, 4), false);
        eq(IteratorDemo.withoutNegatives(Arrays.asList(-1, -2, 3, -4, 5)), Arrays.asList(3, 5));
        eq(IteratorDemo.withoutNegatives(Arrays.asList(-1, -2)), Collections.emptyList());
        eq(IteratorDemo.withoutNegatives(Collections.<Integer>emptyList()), Collections.emptyList());
        java.util.List<Integer> input = Arrays.asList(0, 2, 4);
        eq(IteratorDemo.withoutNegatives(input), input);
        eq(input, Arrays.asList(0, 2, 4));
        // Selected original diagnostic traces, independent of the worked examples.
        eq(9 / 2, 4);
        eq("Total " + 2 + 3, "Total 23");
        eq(2 + 3 + " total", "5 total");
        eq("PROGRAM".substring(1, 4), "ROG");
        eq("PROGRAM".indexOf("Z"), -1);
        int zero = 0;
        eq(zero != 0 && 20 / zero > 2, false);
        int[][] rows = new int[3][0];
        eq(rows.length, 3); eq(rows[0].length, 0);
        java.util.List<Integer> numbers = new java.util.ArrayList<>(Arrays.asList(1, 2, 1));
        numbers.remove(1); numbers.remove(Integer.valueOf(1));
        eq(numbers, Arrays.asList(1));
        System.out.println("PASS: decision boundaries, iterator cases and diagnostic traces");
    }
}
'''

def check():
    records = json.loads((ROOT/'00-Course-Info/sources/oracle-starters.json').read_text())
    count = 0
    for record in records:
        for relative in record['files']:
            file = ROOT/relative
            assert file.is_file(), relative
            assert hashlib.sha256(file.read_bytes()).hexdigest() == record['file_sha256'][relative], relative
            count += file.suffix == '.java'
    assert len(records) == 13 and count == 14
    print(f'PASS: {len(records)} restored ZIP inventories and {count} working Java starter checksums')
    with tempfile.TemporaryDirectory(prefix='oracle-review-') as folder:
        folder = Path(folder)
        harness = folder/'OracleReviewCheck.java'
        harness.write_text(HARNESS, encoding='utf-8')
        subprocess.run(['javac', '--release', '8', '-d', str(folder),
                        str(ROOT/'05-Conditionals/examples/DecisionRules.java'),
                        str(ROOT/'07-Arrays-and-ArrayLists/examples/IteratorDemo.java'),
                        str(harness)], check=True, capture_output=True, text=True)
        result = subprocess.run(['java', '-cp', str(folder), 'OracleReviewCheck'],
                                check=True, capture_output=True, text=True)
        print(result.stdout.strip())
        # The restored method-test companion must compile with its supplied calculator.
        subprocess.run(['javac', '--release', '8', '-d', str(folder),
                        str(ROOT/'04-Methods-and-Library-Classes/exercises/Calculator4/Calculator4.java'),
                        str(ROOT/'04-Methods-and-Library-Classes/exercises/CalculatorTest4/CalculatorTest4.java')],
                       check=True, capture_output=True, text=True)
        print('PASS: restored CalculatorTest4 compiles with Calculator4')

if __name__ == '__main__':
    check()
