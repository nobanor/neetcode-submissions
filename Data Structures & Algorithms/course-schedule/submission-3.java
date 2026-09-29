class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> prereqMap = new HashMap<>();

        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, prereqMap, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> visited) {

        if(visited.contains(course)) {
            return false;
        }

        if(prereqMap.get(course).isEmpty()) {
            return true;
        }

        visited.add(course);
        List<Integer> prereqs = prereqMap.get(course);

        for(int prereq : prereqs) {
            if(!dfs(prereq, prereqMap, visited)) {
                return false;
            }
        }

        prereqMap.put(course, new ArrayList<>());

        visited.remove(course);
        return true;
    }
}
