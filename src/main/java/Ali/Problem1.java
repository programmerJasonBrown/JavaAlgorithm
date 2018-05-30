package Ali;

import java.util.*;

public class Problem1 {
    static class BossFree {
        int day;
        int begin;
        int end;
        String adress;

        public BossFree(int day, int begin, int end, String adress) {
            this.day = day;
            this.begin = begin;
            this.end = end;
            this.adress = adress;
        }
    }

    static class Activity {
        int day;
        int begin;
        int end;
        int value;
        String adress;

        public Activity(int day, int begin, int end, int value, String adress) {
            this.day = day;
            this.begin = begin;
            this.end = end;
            this.value = value;
            this.adress = adress;
        }
    }

    public static class MinCostCompartor implements Comparator<BossFree> {
        @Override
        public int compare(BossFree b1, BossFree b2) {
            return b1.begin - b2.begin;
        }
    }

    public static void main(String[] args) {
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        String line1 = scanner.nextLine();
        HashMap<String, BossFree> hmFree = new HashMap<>();
        line1.trim();
        String[] strings = line1.split(";");
        for (String x : strings) {
            String[] splits = x.split(":");
            int day = Integer.parseInt(splits[0]);
            String adress = splits[2];
            String[] split1s = splits[1].split("-");
            int begin = Integer.parseInt(split1s[0]);
            int end = Integer.parseInt(split1s[1]);
            BossFree bossFree = new BossFree(day, begin, end, adress);
            hmFree.put(adress, bossFree);
        }

        String line2 = scanner.nextLine();
        String[] strings2 = line2.split(";");
        List<Activity> list = new ArrayList<>();
        for (String x : strings2) {
            String[] splits2 = x.split(":");
            int day = Integer.parseInt(splits2[0]);
            String adress = splits2[2];
            String[] split1s = splits2[1].split("-");
            int begin = Integer.parseInt(split1s[0]);
            int end = Integer.parseInt(split1s[1]);
            int value = Integer.parseInt(splits2[3]);
            Activity activity = new Activity(day, begin, end, value, adress);
            list.add(activity);
        }
        for (Activity x : list) {
            if (hmFree.containsKey(x.adress)) {
                BossFree bossFree = hmFree.get(x.adress);
                if (bossFree.begin < x.begin && bossFree.end > x.end){
                    count+=x.value;
                }
            }
        }

        System.out.println(count);
    }
}
