import java.util.Scanner;
class  Library   
{  
    public void addBook(String title, String author, int year)   
    {  
        if (isValidInput(title, author, year))   
        {  
            System.out.println("Book Added:");  
            System.out.println("Title: " + title);  
            System.out.println("Author: " + author);  
            System.out.println("Year: " + year);  
            System.out.println();  
        }          
else  
        {  
            System.out.println("Invalid book information.");  
        }  
    }  
  
    protected boolean isValidInput(String title, String author, int year)  
    {  
        return !title.isEmpty() && !author.isEmpty() && (year >= 1000 && 
year <= 9999);  
    }  
}  
  
class DigitalLibrary extends Library  
{  
    public void addBook(String title, String author, int year, String format, 
String downloadLink)  
    {  
        if (isValidInput(title, author, year) && isValidDigitalInput(format, 
downloadLink)) 
        {  
            System.out.println("Digital Book Added:");  
            System.out.println("Title: " + title);  
            System.out.println("Author: " + author);  
            System.out.println("Year: " + year);  
            System.out.println("Format: " + format);  
            System.out.println("Download link: " + downloadLink);  
        }          
else  
        {  
            System.out.println("Invalid digital book information.");  
        }  
    }  
  
    private boolean isValidDigitalInput(String format, String downloadLink)  
    {  
        String[] validFormats = {"PDF", "TXT","ODT", "XSL"};         
for (String validFormat : validFormats)  
        {  
            if (format.equals(validFormat) && !downloadLink.isEmpty())  
            {  
                return true;  
            }  
        }  
        return false;  
    }  
}  
  
class Main  
{  
    public static void main(String[] args)  
    {  
        Scanner sc = new Scanner(System.in);  
  
        String physicalTitle = sc.nextLine();         
	String physicalAuthor = sc.nextLine();       
	int physicalYear = sc.nextInt();         
	sc.nextLine();  
         
        Library library = new Library();  
        library.addBook(physicalTitle, physicalAuthor, physicalYear);  
  
       String digitalTitle = sc.nextLine();  
       String digitalAuthor = sc.nextLine();         
        int digitalYear = sc.nextInt(); 
        sc.nextLine();  
        String digitalFormat = sc.nextLine();  
        String downloadLink = sc.nextLine();  
  
        DigitalLibrary digitalLibrary = new DigitalLibrary(); 
        digitalLibrary.addBook(digitalTitle, digitalAuthor, digitalYear, digitalFormat, downloadLink);  
    }  
}
