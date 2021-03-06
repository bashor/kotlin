package  As

val staticProperty : String = "1"

val String.staticExt  = "1"

open class A(val init: String) {

    open val property : String = init

    private val privateProperty : String = init

    val String.ext  = "1"

    val Int.myInc : Int
        get() = this + 1

    open fun getPrivate() : String {
        return privateProperty;
    }

    open fun getExt() : String {
        return "0".ext;
    }

    public var backingField : Int = 0
        get() = $backingField.myInc
        set(s) = $backingField = s

}

open class B(init: String) : A("1") {

    override val property: String = init

    fun getOpenProperty(): String {
        return super<A>.property
    }

    fun getWithBackingFieldProperty(): String {
        return $property
    }
}

fun box() : String {
    val a = A("1");
    val b = B("0");
    a.backingField = 0
    val result = a.property + a.getPrivate() + staticProperty + "0".staticExt + a.getExt() +
       a.backingField + a.backingField +
       b.getOpenProperty() + b.property + b.getWithBackingFieldProperty()

    return if (result == "1111111100") "OK" else "fail"
}
