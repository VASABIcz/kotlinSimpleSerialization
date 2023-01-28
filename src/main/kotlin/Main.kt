import kotlin.reflect.full.*

@FieldOrdering(["lol", "xd"])
data class Lol @PrimarySerializable constructor(val lol: String, val xd: Float)

@FieldOrdering(["e", "c", "ee", "n", "gg"])
data class TestClass @PrimarySerializable constructor(
    val e: String,
    val c: Int,
    val ee: Lol,
    val n: @TypeField([String::class]) MutableList<String>,
    val gg: @TypeField([String::class, String::class]) Map<String, String>
)

fun main(args: Array<String>) {
    val s = SimpleSerializer()
    s.serialize(TestClass("UwU", 4, Lol("SUS", 10.5f), mutableListOf("xd", "test"), hashMapOf("kotlin" to "pog")))
    println(s.data.strip())
    val d = SimpleDeserializer(s.data)
    val clr = d.deserialize<TestClass>()
    println(clr)
}