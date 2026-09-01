class Solution {
    public boolean isMatch(String s, String p) {

        Boolean[][] dp = new Boolean[s.length()][p.length()];

        return solve(0, 0, s, p, dp);
    }

    boolean solve(int i, int j, String s, String p, Boolean[][] dp) {

        // Both finished
        if (i == s.length() && j == p.length()) {
            return true;
        }

        // Pattern finished, string still remaining
        if (j == p.length()) {
            return false;
        }

        // String finished
        if (i == s.length()) {

            // Remaining pattern must contain only '*'
            while (j < p.length()) {
                if (p.charAt(j) != '*') {
                    return false;
                }
                j++;
            }

            return true;
        }

        // Already calculated
        if (dp[i][j] != null) {
            return dp[i][j];
        }

        boolean ans;

        if (s.charAt(i) == p.charAt(j)) {

            ans = solve(i + 1, j + 1, s, p, dp);

        } else if (p.charAt(j) == '?') {

            ans = solve(i + 1, j + 1, s, p, dp);

        } else if (p.charAt(j) == '*') {

            ans = solve(i, j + 1, s, p, dp)
               || solve(i + 1, j, s, p, dp);

        } else {

            ans = false;
        }

        dp[i][j] = ans;

        return ans;
    }
}