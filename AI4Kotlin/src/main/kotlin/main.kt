import CausalReasoning.PTree

fun main() {
    println("Probability Trees")

    val leaf30 = PTree.Node(mutableListOf(Pair("Z","0")),null)
    val leaf31 = PTree.Node(mutableListOf(Pair("Z","1")),null)
    val leaf32 = PTree.Node(mutableListOf(Pair("Z","0")),null)
    val leaf33 = PTree.Node(mutableListOf(Pair("Z","1")),null)
    val leaf34 = PTree.Node(mutableListOf(Pair("Y","0")),null)
    val leaf35 = PTree.Node(mutableListOf(Pair("Y","1")),null)
    val leaf36 = PTree.Node(mutableListOf(Pair("Y","0")),null)
    val leaf37 = PTree.Node(mutableListOf(Pair("Y","1")),null)

    val leaf38 = PTree.Node(mutableListOf(Pair("Y","0")),mutableListOf(Pair(0.5,leaf30),Pair(0.5,leaf31)))
    val leaf39 = PTree.Node(mutableListOf(Pair("Y","1")),mutableListOf(Pair(2.0/3.0,leaf32),Pair(1.0/3.0,leaf33)))
    val leaf40 = PTree.Node(mutableListOf(Pair("Z","0")),mutableListOf(Pair(0.5,leaf34),Pair(0.5,leaf35)))
    val leaf41 = PTree.Node(mutableListOf(Pair("Z","1")),mutableListOf(Pair(4.0/5.0,leaf36),Pair(1.0/5.0,leaf37)))

    val leaf42 = PTree.Node(mutableListOf(Pair("X","0")),mutableListOf(Pair(3.0/5.0,leaf38),Pair(2.0/5.0,leaf39)))
    val leaf43 = PTree.Node(mutableListOf(Pair("X","1")),mutableListOf(Pair(1.0/3.0,leaf41),Pair(2.0/3.0,leaf40)))

    val pTree =  PTree(transitions = mutableListOf(
            Pair(5.0/11.0,leaf42),
            Pair(6.0/11.0,leaf43)))

    pTree.print()

    println()
    var minCut = pTree.evaluateEvent(Pair("Y","1"))
    println("True Min Cut (Y=1): ${minCut.first}")
    println("False Min Cut (Y=1): ${minCut.second}")

    println()
    var minCutZ = pTree.evaluateEvent(Pair("Z","0"))
    println("True Min Cut (Z=0): ${minCutZ.first}")
    println("False Min Cut (Z=0): ${minCutZ.second}")
}