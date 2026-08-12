class Solution {

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();

        for(String str : strs) {
            int len = str.length();

            sb.append(len);
            sb.append("#");
            sb.append(str);
        }

        return new String(sb.toString());
    }

    public List<String> decode(String str) {

        List<String> strs = new ArrayList<>();
        int i = 0;

        while(i < str.length()) {
            int j = i;
            while(str.charAt(j) != '#') {
                j++;
            }

            //Get length of the string 
            int length = Integer.parseInt(str.substring(i,j));
            i = j + 1;
            j = i + length;
            strs.add(str.substring(i,j));

            i = j;
        }

        return strs;
    }
}
