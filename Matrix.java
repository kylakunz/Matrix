/*************************************************
* Author: Kyla Kunz
*
* Represents a metrix of floating point numbers.
**************************************************/

import java.util.Arrays;

public class Matrix {
   // fields
   private int m;
   private int n;
   private double[][] data;
   
   // constructors
   public Matrix(int m, int n) {
      data = new double[m][n];
      
      for (int i = 0; i < m; i++) {
         for (int j = 0; j < n; j++) {
            data[i][j] = Math.random();
         }
      }      
   }
   
   // copy Constructor
   // A defensive copy is necessary when a mutable reference type
   // is passed as an argument to initalize a field
   public Matrix(double[][] data) {
   
      // create defesivee copy of data, which is immutable
      this.data = Arrays.copyOf(data, data.length); // Arrays.copyOf creates a shallow copy
      for(int i = 0; i < data.length; i++) {        // important to copy every row individually
         this.data[i] = Arrays.copyOf(data[i], data[i].length);
      }
      
      this.m = data.length; // calculated based on the data
      this.n = data[0].length;
   }
   
   // methods
   public Matrix plus(Matrix other) {
      return null; // TODO
   }
   
   public Matrix minus(Matrix other) {
      return null; // TODO
   }
   
   public void print() {
      for(double[] row : data) {
         for(double el : row) {
            System.out.printf("%5.2f ", el);
         }
         System.out.println();
      }
   }
   
   // = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = 
   // T e s t  C l i e n t 
   
   public static void main(String[] args) {
      Matrix m = new Matrix(4, 5);
      System.out.println("m:");
      m.print();
      System.out.println();
      
      double[][] data = new double[][]{
         {0.00, 0.01, 0.02, 0.03},
         {0.10, 0.11, 0.12, 0.13},
         {0.20, 0.21, 0.22, 0.23}
      };

      Matrix m2 = new Matrix(data);
      System.out.println("m2:");
      m2.print();
      System.out.println();      
      
      // client modifies data after creating the matrix
      data[0][0] = 99.99;
      data[1] = new double[] {0.55, 0.66, 0.77, 0.88};
      
      System.out.println("modified data:");
      for(double[] row : data) {
         for(double el : row) {
            System.out.printf("%5.2f ", el);
         }
         System.out.println();
      }
      System.out.println();
      
      // client wants to have a second look at matrix m2
      System.out.println("m2:");
      m2.print();
      System.out.println();      
      
      // adding and subtracting matrices
   }
}