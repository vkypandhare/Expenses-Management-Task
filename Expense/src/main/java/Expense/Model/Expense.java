package Expense.Model;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Getter
@Builder
@Data
@AllArgsConstructor
@ToString



public class Expense{

   private int expenses_Id;
   private String expenses_Name;
   private String add_Expenses;
   private String expenses_Description;
   private Date start_Date;
   private Date end_Date;


}
