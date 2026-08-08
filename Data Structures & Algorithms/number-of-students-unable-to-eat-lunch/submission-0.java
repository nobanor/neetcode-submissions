class Solution {
    public int countStudents(int[] students, int[] sandwiches) {

        //Put students in queue
        //Put sandwiches in stack or just iterate to avoid extra space
        Queue<Integer> studentQueue = new LinkedList<>();
        int sandwichIndex = 0;

        for(int student : students) {
            studentQueue.add(student);
        }

        int numStudentsUnableToEat = 0;

        while(!studentQueue.isEmpty()) {
            int currentStudent = studentQueue.poll();

            if(currentStudent == sandwiches[sandwichIndex]) {
                sandwichIndex++;
                numStudentsUnableToEat = 0;
            } else {
                numStudentsUnableToEat++;
                studentQueue.add(currentStudent);
            }

            if(numStudentsUnableToEat >= studentQueue.size()) {
                return studentQueue.size();
            }
        }

        return 0;
    }
}