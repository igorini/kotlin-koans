package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        val yearCompare = year.compareTo(other.year)
        if (yearCompare != 0) return yearCompare

        val monthCompare = month.compareTo(other.month)
        if (monthCompare != 0) return monthCompare

        return dayOfMonth.compareTo(other.dayOfMonth)
    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(val start: MyDate, val endInclusive: MyDate) {
    operator fun contains(date: MyDate) = date >= start && date <= endInclusive
}
