class SimpleSerializer : Serializer {
    var data = ""
    override fun writeInt(it: Int): Boolean {
        data += " "
        data += it
        return true
    }

    override fun writeString(it: String): Boolean {
        data += " "
        data += it
        return true
    }

    override fun writeBool(it: Boolean): Boolean {
        data += " "
        data += it
        return true
    }

    override fun writeFloat(it: Float): Boolean {
        data += " "
        data += it
        return true
    }
}

class SimpleDeserializer(msg: String): Deserializer {
    private val internalData = msg.strip().split(" ")
    private var index = 0

    override fun readInt(): Int? {
        return internalData.getOrNull(index++)?.toIntOrNull()
    }

    override fun readString(): String? {
        return internalData.getOrNull(index++)
    }

    override fun readBool(): Boolean? {
        return internalData.getOrNull(index++)?.toBooleanStrictOrNull()
    }

    override fun readFloat(): Float? {
        return internalData.getOrNull(index++)?.toFloatOrNull()
    }
}