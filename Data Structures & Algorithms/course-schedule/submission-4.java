class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> processed = new HashSet<>();

        for(int course = 0; course < numCourses; course++) {
            prereqMap.put(course, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course, prereqMap, visiting, processed)) {
                return false;
            }
        }
        
        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visiting, Set<Integer> processed) {

        if(processed.contains(course)) {
            return true;
        }

        if(visiting.contains(course)) {
            return false;
        }

        visiting.add(course);
        List<Integer> prereqs = prereqMap.get(course);

        for(int prereq : prereqs) {
            if(!dfs(prereq, prereqMap, visiting, processed)) {
                return false;
            }
        }

        visiting.remove(course);
        processed.add(course);
        return true;
    }
}
