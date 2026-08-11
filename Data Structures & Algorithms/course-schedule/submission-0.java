class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        for(int i = 0; i < numCourses; i++) {
            prereqMap.put(i, new ArrayList<>());
        }

        for(int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
        }

        for(int i = 0; i < numCourses; i++) {
            if(!dfs(i, prereqMap, visited)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int currentCourse, Map<Integer, List<Integer>> prereqMap, Set<Integer> visited) {

        //Base case
        if(visited.contains(currentCourse)) {
            return false;
        }

        if(prereqMap.get(currentCourse).isEmpty()) {
            return true;
        }

        visited.add(currentCourse);

        List<Integer> prereqs = prereqMap.get(currentCourse);

        for(int course : prereqs) {
            if(!dfs(course, prereqMap, visited)) {
                return false;
            }
        }

        prereqMap.put(currentCourse, new ArrayList<>());
        visited.remove(currentCourse);

        return true;

    }
}
