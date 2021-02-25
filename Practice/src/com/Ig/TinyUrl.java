package com.Ig;

public class TinyUrl {

   public String shortUrl(int id){
       char map[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

       StringBuffer shortUrl = new StringBuffer();

       while(id>0){
          shortUrl.append(map[id%62]);
            id = id/62;
       }
        return shortUrl.reverse().toString();

   }
   public int shortURLtoID(String shortURL)
   {
      int id = 0; // initialize result

      // A simple base conversion logic
      for (int i = 0; i < shortURL.length(); i++)
      {
         if ('a' <= shortURL.charAt(i) &&
               shortURL.charAt(i) <= 'z')
            id = id * 62 + shortURL.charAt(i) - 'a';
         if ('A' <= shortURL.charAt(i) &&
               shortURL.charAt(i) <= 'Z')
            id = id * 62 + shortURL.charAt(i) - 'A' + 26;
         if ('0' <= shortURL.charAt(i) &&
               shortURL.charAt(i) <= '9')
            id = id * 62 + shortURL.charAt(i) - '0' + 52;
      }
      return id;
   }
   public static void main(String[] args){
      TinyUrl tinyUrl = new TinyUrl();
      int n= 12345;
      String shortUrlString = tinyUrl.shortUrl(n);
      int longUrl = tinyUrl.shortURLtoID(shortUrlString);
      System.out.println("Tiny Url of integer id " + shortUrlString);
      System.out.println("Tiny Url of String Id " + longUrl);
   }
}
