package heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class RearrangeCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(rearrangeCharacters(str));

        sc.close();
    }

    static String rearrangeCharacters(String s) {
        int[] map = new int[26];
        for (char ch : s.toCharArray()) {
            map[ch - 'a']++;
        }

        StringBuilder ans = new StringBuilder();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                pq.offer(new Pair((char) ('a' + i), map[i]));
            }
        }

        Pair hold = pq.poll();
        ans.append(hold.ch);
        hold.freq--;

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            ans.append(curr.ch);
            curr.freq--;

            if (hold.freq > 0) {
                pq.offer(hold);
            }

            hold = curr;
        }

        return ans.length() == s.length() ? ans.toString() : "";
    }
}

class Pair {
    char ch;
    int freq;

    public Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }
}