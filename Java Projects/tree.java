import java.io.*;

class tree {
   public static void main(String[] args) throws IOException { 
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      System.out.println("This is a program on family tree");
      System.out.println("Family tree should start with one person");
      System.out.println("Enter your family tree sequentially");
      String[] fam_tree = new String[50];
      String[] father = new String[50];
      int[] noc = new int[50];
      int c=0,i=0;
      while(c>=0) {
         System.out.println("Enter member name and his number of children");
         fam_tree[i] = br.readLine();
         noc[i] = Integer.parseInt(br.readLine());
         c=c+noc[i];
         c=c-1;
         i=i+1;
      }
      int count = 0, j=0;
      while((count<50)&&(fam_tree[j]!=null)) {
         for(int k=0; k<noc[j];++k) {
            father[count+k+1] = fam_tree[j];
         }           
      count = count+noc[j];
      j=j+1;
      }
      System.out.println();
      System.out.println("Here is your family tree in the required format");
      for(j=0;j<50 && (fam_tree[j]!=null);++j) {
         System.out.print(fam_tree[j]+"\t");
         System.out.print(noc[j]+"\t");
         System.out.print(father[j]);
         System.out.println();
      }
      System.out.println("Enter the person's name you want to know about");
      String p = br.readLine();
      c=0;
      int fi=0;
      for(i=0;i<50;++i) {
         if(fam_tree[i] == p) {
         c++;
         break;
         }
      }

   if (c==0)
   System.out.println("That person is not there in list");
   else {
   System.out.println("Person's name : \t"+fam_tree[i]);
   if (father[i]!=null) {
   System.out.println("Father of "+p+" is :\t"+father[i]);
   for(fi=0;fi<50;++fi) {
   if(fam_tree[fi] == father[i]) {
   break;
   }
   }
   }
   else
   System.out.println("Father of "+p+" is :\tData Unavailable");
   System.out.print("Sons of "+p+" are :\t");
   for(int k=0;k<noc[i];++k)
   {
   System.out.print(fam_tree[k+i+1]+" ");
   }
   System.out.println();
   if (father[i]!=null)
   {
   System.out.print("Brothers of "+p+" are :\t");
   for(int k=0;k<noc[fi];++k)
   {
   if (fam_tree[k+fi+1]==p)
   continue;
   else
   System.out.print(fam_tree[k+fi+1]+" ");
   }
   System.out.println();
   }
   else
   System.out.println("Brothers of "+p+" are :\tData Unavailable");
   }
   }        
}