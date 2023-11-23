fun main(args: Array<String>) {
    val geometry = mutableListOf(
        Point(0.0, 0.0),
        Point.ColoredPoint("Синий" , 1.0, 1.0),
        Point.Line(2.0, 7.0, 2.0, 3.0),
        Point.ColoredLine("Синий", 2.0, 7.0, 3.0, 4.0),
        Point.Polygons(Point(-1.0, 1.0), Point(-1.0, 5.0), Point(-5.0, 5.0), Point(-5.0, 1.0))
    )
    var pol = Point.Polygons(Point(-1.0, 1.0), Point(-1.0, 5.0), Point(-5.0, 5.0), Point(-5.0, 1.0))
    pol.moveXY(1.0, 1.0)
    println(pol.toString())
}

open class Point(_x:Double, _y: Double){
    var X : Double = 0.0
        set(value){ field = value}
        get() {return field}
    var Y : Double = 0.0
        set(value){ field = value}
        get() {return field}
        init {
            X = _x
            Y = _y
        }
    constructor() : this(0.0, 0.0)
    constructor(_x: Double) : this(_x, 0.0)

    override fun toString() : String{
        return "Точка:\nX = $X\nY = $Y"
    }

    class ColoredPoint(): Point(){
        var Color : String = "Черный"
            set(value){ field = value}
            get() {return field}

        constructor(_color: String, _x:Double, _y: Double) : this()
        constructor(_x: Double) : this("Черный",_x, 0.0)
        constructor(_color: String) : this(_color, 0.0, 0.0)
        constructor(_color: String, _x: Double) : this(_color, _x, 0.0)

        override fun toString(): String {
            return "Точка:\nX = $X\nY = $Y. \nЦвет: $Color"
        }
    }

    open class Line(_x: Double, _x2: Double, _y: Double, _y2: Double) : Point(){
        var X2 : Double = 0.0
            set(value) {field = value}
            get() {return field}
        var Y2 : Double = 0.0
            set(value) {field = value}
            get() {return field}
        init {
            X2 = _x2
            Y2 = _y2
        }
        constructor() : this(0.0, 0.0, 0.0, 0.0)
        constructor(_x: Double) : this(_x, 0.0, 0.0, 0.0)
        constructor(_x: Double, _x2: Double) : this(_x, _x2, 0.0, 0.0)
        constructor(_x: Double, _x2: Double, _y: Double) : this(_x, _x2, _y, 0.0)

        override fun toString(): String {
            return "Линия:\nX = $X\nY = $Y. \nX2 = $X2\nY2 = $Y2"
        }
    }

    class ColoredLine() : Line(){
        var Color: String = "Черный"
            set(value) {field=value}
            get() {return field}

        constructor(_color: String,_x: Double, _x2: Double, _y: Double, _y2: Double) : this()
        constructor(_color: String) : this(_color, 0.0, 0.0, 0.0, 0.0)
        constructor(_color: String, _x: Double) : this(_color,_x, 0.0, 0.0, 0.0)
        constructor(_color:String, _x: Double, _x2: Double) : this(_color,_x, _x2, 0.0, 0.0)
        constructor(_color: String, _x: Double, _x2: Double, _y: Double) : this(_color,_x, _x2, _y, 0.0)

        override fun toString(): String {
            return "Линия:\nX = $X\nY = $Y. \nX2 = $X2\nY2 = $Y2.\nЦвет: $Color"
        }
    }

    class Polygons(vararg _points: Point) : Line(){
        var points: Array<Point>
        init {
            points = _points as Array<Point>
        }

        fun moveOx(_ox: Double){
            for (i in points)
                i.X += _ox
        }

        fun moveOy(_oy: Double){
            for (i in points)
                i.Y += _oy
        }

        fun moveXY(_ox: Double, _oy: Double){
            for (i in points) {
                i.X += _ox
                i.Y += _oy
            }
        }

        override  fun toString():String{
            var str: String = "Многоугольник с точками:\n"
            for (i in points){
                str+="(${i.X},${i.Y})\n"
            }
            return str
        }
    }
}