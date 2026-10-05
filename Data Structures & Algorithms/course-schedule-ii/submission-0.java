class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        Map<Integer, List<Integer>> prereqMap = new HashMap<>();
        Set<Integer> path = new HashSet<>();
        Set<Integer> visited = new HashSet<>();
        List<Integer> courses = new ArrayList<>();

        for(int course = 0; course < numCourses; course++) {
            prereqMap.put(course, new ArrayList<>());
        }

        for(int[] course : prerequisites) {
            prereqMap.get(course[0]).add(course[1]);
        }

        for(int course = 0; course < numCourses; course++) {
            if(!dfs(course, prereqMap, path, visited, courses)) {
                return new int[0];
            }
        }

        int[] result = new int[courses.size()];

        for(int course = 0; course < courses.size(); course++) {
            result[course] = courses.get(course);
        }

        return result;

    }

    private boolean dfs(int course, Map<Integer, List<Integer>> prereqMap, Set<Integer> path, Set<Integer> visited, List<Integer> courses) {

        if(visited.contains(course)) {
            return true;
        }

        if(path.contains(course)) {
            return false;
        }

        path.add(course);
        List<Integer> prereqs = prereqMap.get(course);

        for(int prereq : prereqs) {
            if(!dfs(prereq, prereqMap, path, visited, courses)) {
                return false;
            }
        }

        path.remove(course);
        visited.add(course);
        courses.add(course);

        return true;
    }
}
