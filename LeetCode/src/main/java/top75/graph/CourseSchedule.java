package top75.graph;

import java.util.*;


public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> nodeMap = new HashMap<>();

        //create all vertices
        for(int i= 0; i< numCourses; i++){
            nodeMap.put(i, new ArrayList<>());
        }

        //create relationship of courses
        for (int i =0 ; i < prerequisites.length; i++){
            nodeMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        ArrayList<Integer> visited = new ArrayList<>();

        for (int i =0 ; i < numCourses; i++){
            if (!isDone(i, nodeMap, visited))
                return false;
        }

        return true;
    }

    public boolean isDone(int courseId, HashMap<Integer, List<Integer>> nodeMap, ArrayList<Integer> visited){
        if (nodeMap.get(courseId).isEmpty()){
            return true;
        } else if (visited.contains(courseId)) {
            return false;
        }

        visited.add(courseId);

        for (int course : nodeMap.get(courseId)){
            if (!isDone(course, nodeMap, visited))
                return false;
        }
        nodeMap.put(courseId, new ArrayList<>());
        visited.remove(Integer.valueOf(courseId));
        return true;
    }


    public static void main(String[] args) {
        //int[][] preRequisites = {{0,10}, {3,18}, {5,5}, {6,11}, {11,14}, {13,1}, {15,1}, {17,4}};
        //int[][] preRequisites = {{0,1}, {1,0}};
        //int[][] preRequisites = {{1,4}, {2,4}, {3,1}, {3,2}};
        int[][] preRequisites = {{1,0}, {2,6}, {1,7}, {6,4}, {7,0}, {0,5}};

        CourseSchedule courseSchedule = new CourseSchedule();

        System.out.println(courseSchedule.canFinish(8, preRequisites));
    }



}
