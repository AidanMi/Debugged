import java.time.LocalDate                  //Needed Imports
import java.time.chrono.ChronoLocalDate     //
import java.time.format.DateTimeFormatter   //
import java.time.temporal.ChronoUnit        //
//////////////////////////////////////////////
fun main(args: Array<String>) {

    //var scanner = "" // to get user input

    val today = LocalDate.now() //Forgot ()

    // set date format
    val formatter = DateTimeFormatter.ofPattern("M/d/yyyy")

    // display today's date formatted
    val textToday = today.format(formatter)
    println("Today's date is: $textToday")//Variable is capitalized

    // get info from user
    println("What month were you born in? (Enter as number: January = 1)")
    val myMonth = readLine()!!.toInt()
    println("What day were you born? ")
    val myDay = readLine()!!.toInt()
    val myYear = today.year//getYears() does not work, should be .year
    val thisMonth = today.monthValue //getMonthValue does not work, should be today.monthValue

    // assign information to variable birthday
    var birthday = LocalDate.of(myYear, myMonth, myDay)


    // if birthday already happened this year, add one to year
    if (birthday.isBefore(today)) {//Should be .isBefore()
        birthday = birthday.plusYears(1)//Should only add 1 year
    }


    val nextBirthday = birthday.format(formatter)
    // calculate days till next birthday

    val daysToBirthday = today.until(birthday, ChronoUnit.DAYS) //Should have ChronoUnit., should have days instead of WEEKS

    if (myMonth == thisMonth && myDay == today.getDayOfMonth()) { //Should be &&, not and
        println("Happy Birthday!")
    } else {
        println("Your next birthday is: $nextBirthday")
        println("There are $daysToBirthday days till your next birthday!")
    }

}