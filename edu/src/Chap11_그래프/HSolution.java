/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chap11_그래프;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author user
 */
public class HSolution {

    public static int solution(int n, int[][] computers) {
        // DFS
        //1 스택으로 할거임
        //메서드 하나 만들고
        // 매개변수 확인(computer, visited, i)

        int answer = 0;
        //2 간단설계
        //booelan[] visited;
        //int network = 0;
        // for (int i = 0; i < n; i++) {
        //  if(visited[i]){
        //     dfs()
        //     newtwork++

        //  }   
        // }
        // return newtwork;
        //3.부족한점이있나
        return answer;
    }

    static int solutionStack(int n, int[][] computers){
        int networkCount = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                dfsStack(computers, visited, i);
                networkCount++;
            }
        }
        return networkCount;
    }


    static void dfsStack(int[][] computers, boolean[] visited, int start) {
        // TODO Auto-generated method stub
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        visited[start] = true;

        while(!stack.isEmpty()){
            int current = stack.pop();
            for(int i=0; i<computers.length; i++){
                if(computers[current][i]==1 && !visited[i]){
                    stack.push(i);
                    visited[i]=true;
                    
                }
            }
        }
    }

    static void dfsQueue(int[][] computers, boolean[] visited, int start) {
        // TODO Auto-generated method stub
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()){
            int current = queue.poll();
            for(int i=0; i<computers.length; i++){
                if(computers[current][i]==1 && !visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                    
                }
            }
        }
    }


    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = {
            {1,1,0}, 
            {1,1,0}, 
            {0,0,1}
        };

        int n2 = 3;
        int[][] computers2 = {
            {1,1,0}, 
            {1,1,1}, 
            {0,1,1}
        };
        System.out.println("DFS Case1 : "+solutionStack(n1, computers1));
        System.out.println("DFS Case2 : "+solutionStack(n2, computers2));

    }
}
