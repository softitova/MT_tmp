package parser

//
//import antlr.generated.ExpressionLexer
//import antlr.generated.ExpressionParser


import antlr.generated.ExpressionLexer
import antlr.generated.ExpressionParser
import org.antlr.v4.runtime.*
import org.antlr.v4.runtime.tree.ParseTree

/**
 * Created by Titova Sophia on 29.10.17.
 */
class ExpressionWalker() {

     public fun walk(text: String): ParseTree? {
        var res: ParseTree? = null
        try {
            res =
                    ExpressionParser(
                            CommonTokenStream(
                                    ExpressionLexer(
                                            ANTLRInputStream(
                                                    text.byteInputStream()))))
                            .prog()

        } catch (e: Throwable) {
            println("ERROR WITH TEXT : $text")
            println(e.stackTrace)
        }
        return res
    }

}

/**
 * Created by Titova Sophia on 29.10.17.
 */
public data class ExprUnit(val node: ParseTree? = null)