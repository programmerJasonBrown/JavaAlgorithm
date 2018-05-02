package searchProblem.searchInString;

/*
*
* O（n^2）复杂度
* */
public class StringMatchProblem {
    public int strStr(String source, String target) {
        if (source == null || target == null || source.length() < target.length())
            return -1;
        int target_j = 0;
        int source_i = 0;
        while (source_i < source.length() && target_j < target.length()) {
            if (source.charAt(source_i) == target.charAt(target_j)) {
                source_i++;
                target_j++;
            } else {
                source_i = source_i - target_j + 1;
                target_j = 0;
            }
        }
        if (target_j == target.length())
            return source_i - target.length();
        return -1;
    }

    public static void main(String[] args) {
        StringMatchProblem matchProblem = new StringMatchProblem();
        System.out.println(matchProblem.strStr("tartarget", "target"));
    }
}
