/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chap11_그래프;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author user
 */
public class Hamilton {

    static int N;
    static int M;
    static List<List<Integer>> graph;
    static boolean[] visited;
    static List<Integer> path;
    static boolean found;

    static void solve(int n, int[][] edges) {
        N = n;
        M = edges.length;

        //입력검증
        if (N < 1 || M > 20) {
            System.out.println("NO");
            return;
        }
        //그래프 초기화
        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        //간선 입력
        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            if (u < 0 || u >= N || v < 0 || v >= N) {
                System.out.println("NO");
                return;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);

        }
        //인접 리스트 정렬(사전순 최소 경로 우선)
        for (int i = 0; i < N; i++) {
            Collections.sort(graph.get(i));
        }

        //각 정점 시작으로 dfs 츄라이
        visited = new boolean[N];
        path = new ArrayList<>();
        found = false;

        for (int start = 0; start < N && !found; start++) {
            Arrays.fill(visited, false);
            path.clear();
            visited[start] = true;
            path.add(start);
            dfs(start, 1);

        }
        if(found){
            System.out.println("YES");
            for(int i = 0; i < path.size(); i++){
                if(i > 0){
                  System.out.print("\t");  
                }
                System.out.print(path.get(i));
            }
            System.out.println("");
        }
        else{
            System.out.println("NO");
            
        }
    }

    static void dfs(int current, int depth) {
        // TODO Auto-generated method stub
        if (found) {//이미 경로 찾음
            return;
        }
        //모든 정점 방문시 해밀턴 경로 발견
        if (depth == N) {
            found = true;
            return;
        }
        for(int next : graph.get(current)) {
            if (!visited[next]){
                visited[next]=true;
                path.add(next);
                dfs(next, depth+1);
                
                if(!found){
                    visited[next]=false;
                    path.remove(path.size()-1);
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("== 해밀턴 경로 ==");

        solve(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}});
        solve(4, new int[][] {{0,1}, {0,2}});
        //입력 데이터 출력
        //해밀턴 경로 있으면 yes, 경로 출력, 종료
        //없으면 No, 종료

        //N, int[][] edges
        //void solve(int n, int[][] edges)
    }
}
