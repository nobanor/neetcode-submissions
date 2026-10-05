class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {

        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        Map<Integer, Set<Integer>> prereqChildrenMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        List<Boolean> result = new ArrayList<>();

        for(int course = 0; course < numCourses; course++) {
            prereqMap.put(course, new ArrayList<>());
            prereqChildrenMap.put(course, new HashSet<>());
        }

        for(int[] prereq : prerequisites) {
            prereqMap.get(prereq[0]).add(prereq[1]);
            prereqChildrenMap.get(prereq[0]).add(prereq[1]);
        }
    
        for(int course = 0; course < numCourses; course++) {
            dfs(course, prereqMap, prereqChildrenMap, visited);
        }

        for(int[] query : queries) {
            int prereq = query[0];
            int child = query[1];

            if(prereqChildrenMap.get(prereq).contains(child)) {
                result.add(true);
            } else {
                result.add(false);
            }
        }

        return result;
    }

    private void dfs(int course, Map<Integer, List<Integer>> prereqMap, Map<Integer, Set<Integer>> prereqChildrenMap, Set<Integer> visited) {
        
        if(visited.contains(course)) {
            return;
        }

        List<Integer> currentChildren = prereqMap.get(course);
        Set<Integer> allChildren = prereqChildrenMap.get(course);

        for(int children : currentChildren) {
            dfs(children, prereqMap, prereqChildrenMap, visited);
            allChildren.addAll(prereqChildrenMap.get(children));
        }

        visited.add(course);
    }
}