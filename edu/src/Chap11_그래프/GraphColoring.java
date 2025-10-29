/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chap11_그래프;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author user
 */
class Graph {

    int vertex;
    ArrayList<Integer>[] adj;
    int[] color;

    public Graph(int vertex) {
        this.vertex = vertex;

        adj = new ArrayList[vertex];
        for (int i = 0; i < vertex; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    public void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);

    }

    private boolean isSafe(int vIdx, int c) {
        for (int near : adj[vIdx]) {
            if (color[near] == c) {
                return false;
            }
        }
        return true;
    }

    private boolean canColor(int vIdx, int k) {
        if (vIdx == this.vertex) {
            return true;
        }

        for (int c = 1; c <= k; c++) {
            if (isSafe(vIdx, c)) {
                color[vIdx] = c;

                if (canColor(vIdx + 1, k)) {
                    return true;
                }

                color[vIdx] = 0;
            }
        }

        return false;
    }

    public int findmin() {
        int N = this.vertex;

        for (int k = 1; k <= N; k++) {
            color = new int[N];

            if (canColor(0, k)) {
                return k; // 
            }
        }

        return N;
    }
}

public class GraphColoring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정점 수 입력 : ");
        int vertex = sc.nextInt();
        System.out.print("간선 수 입력 : ");
        int edge = sc.nextInt();

        Graph g = new Graph(vertex);
        System.out.println("간선 정보를" + edge + "번 입력하시오 (a, b)");
        for (int i = 0; i < edge; i++) {
            System.out.print("간선 정보 : ");
            int a = sc.nextInt();
            int b = sc.nextInt();
            g.addEdge(a, b);
        }

        int result = g.findmin();

        System.out.println("최소 색 수 : "+result);
    }
}
