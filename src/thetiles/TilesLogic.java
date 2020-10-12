/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thetiles;

/**
 *
 * @author SHIVA
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class TilesLogic {

    public List<List<Integer>> shuffle() {
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(0, 0, 0, 0));
        ls.add(Arrays.asList(0, 0, 0, 0));
        ls.add(Arrays.asList(0, 0, 0, 0));
        ls.add(Arrays.asList(0, 0, 0, 0));
        Random rand = new Random();
        int x = 1, a, b;
        while (x <= 15) {
            a = rand.nextInt(4);
            b = rand.nextInt(4);
            if (ls.get(a).get(b) == 0) {
                ls.get(a).set(b, x);
                x++;
            }
        }
        if(isSolvable(ls))
            return ls;
        else
            return shuffle();
    }

    public List<Integer> findPos(List<List<Integer>> ls) {
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.size(); j++) {
                if (ls.get(i).get(j) == 0) {
                    return Arrays.asList(i, j);
                }
            }
        }
        return null;
    }

    public int getInvCount(List<List<Integer>> ls) {
        int inv_count = 0;
        List<Integer> res;

        res = new ArrayList<>();
        ls.stream().forEach((x) -> {
            x.stream().forEach((y) -> {
                res.add(y);
            });
        });

        for (int i = 0; i < 15; i++) {
            for (int j = i + 1; j < 16; j++) {
                if (res.get(j) != 0 && res.get(i) != 0 && res.get(i) > res.get(j)) {
                    inv_count++;
                }
            }
        }
        return inv_count;
    }

    public int findXPosition(List<List<Integer>> ls) {
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                if (ls.get(i).get(j) == 0) {
                    return 4 - i;
                }
            }
        }
        return 0;
    }

    public boolean isSolvable(List<List<Integer>> ls) {
        int invCount = getInvCount(ls);
        int pos = findXPosition(ls);
        if (pos % 2 == 1) {
            return !(invCount % 2 == 1);
        } else {
            return invCount % 2 == 1;
        }
    }

    public List<List<Integer>> leftMove(List<List<Integer>> ls) {
        List<Integer> pos = findPos(ls);
        int a = pos.get(0), b = pos.get(1);
        if (b + 1 < ls.size()) {
            ls.get(a).set(b, ls.get(a).get(b + 1));
            ls.get(a).set(b + 1, 0);
            return ls;
        }
        return ls;
    }

    public List<List<Integer>> rightMove(List<List<Integer>> ls) {
        List<Integer> pos = findPos(ls);
        int a = pos.get(0), b = pos.get(1);
        if (b - 1 > -1) {
            ls.get(a).set(b, ls.get(a).get(b - 1));
            ls.get(a).set(b - 1, 0);
            return ls;
        }
        return ls;
    }

    public List<List<Integer>> upMove(List<List<Integer>> ls) {
        List<Integer> pos = findPos(ls);
        int a = pos.get(0), b = pos.get(1);
        if (a + 1 < ls.size()) {
            ls.get(a).set(b, ls.get(a + 1).get(b));
            ls.get(a + 1).set(b, 0);
            return ls;
        }
        return ls;
    }

    public List<List<Integer>> downMove(List<List<Integer>> ls) {
        List<Integer> pos = findPos(ls);
        int a = pos.get(0), b = pos.get(1);
        if (a - 1 > -1) {
            ls.get(a).set(b, ls.get(a - 1).get(b));
            ls.get(a - 1).set(b, 0);
            return ls;
        }
        return ls;
    }

    public boolean isWin(List<List<Integer>> ls) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(1, 2, 3, 4));
        res.add(Arrays.asList(5, 6, 7, 8));
        res.add(Arrays.asList(9, 10, 11, 12));
        res.add(Arrays.asList(13, 14, 15, 0));
        return res.equals(ls);
    }

}
