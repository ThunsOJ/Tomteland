import java.util.*

/*
Tomtarna på Nordpolen har en strikt chefs-hierarki
Högsta chefen för allt är "Tomten"
Under "Tomten" jobbar "Glader" och "Butter"
Under "Glader" jobbar "Tröger", "Trötter"och "Blyger"
Under "Butter" jobbar "Rådjuret", "Nyckelpigan", "Haren" och "Räven"
Under "Trötter" jobbar "Skumtomten"
Under "Skumtomten" jobbar "Dammråttan"
Under "Räven" jobbar "Gråsuggan" och "Myran"
Under "Myran" jobbar "Bladlusen"
Er uppgift är att illustrera tomtens arbetshierarki i en lämplig datastruktur.
(Det finns flera tänkbara datastrukturer här)
Skriv sedan en funktion där man anger ett namn på tomten eller någon av hens underhuggare som
inparameter.
Funktionen listar sedan namnen på alla underlydandesom en given person har
Expempel: Du anger "Trötter" och får som svar ["Skumtomten", "Dammråttan"]"
För att bli godkänd på uppgiften måste du använda rekursion.
 */

class Tomteland {

    val tomteHiearki = mapOf(
        "Tomten" to listOf("Glader", "Butter"),
        "Glader" to listOf("Tröger", "Trötter", "Blyger"),
        "Butter" to listOf("Rådjuret", "Nyckelpigan", "Haren", "Räven"),
        "Trötter" to listOf("Skumtomten"),
        "Skumtomten" to listOf("Dammråttan"),
        "Räven" to listOf("Gråsuggan", "Myran"),
        "Myran" to listOf("Bladlusen")
    )

    fun getUnderlings(currentName: String, res: MutableList<String>): List<String> {

        tailrec fun addUnderlings(currentName: String, res: MutableList<String>, counter: Int): List<String> {
            tomteHiearki.filterKeys { it.equals(currentName, ignoreCase = true) }.map {v -> v.value.forEach{res.add(it)}}
            if(counter == res.size)
                return res
            return addUnderlings(currentName = res[counter], res, counter = counter+1)
        }
        return addUnderlings(currentName, res, 0)
    }

    fun run() {
        val list: MutableList<String> = mutableListOf()
        print("Skriv namn på den du vill söka efter: ")
        val namn = readLine() ?: ""
        println("Här är de underordnade för "
                + "${namn.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() }}: "
                + getUnderlings(namn, list).joinToString (separator = ", "))

    }

}
fun main() {
    val t = Tomteland()
    t.run()
}