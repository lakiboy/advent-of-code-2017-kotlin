package io.dmitrijs.aoc2017

import io.dmitrijs.aoc2017.Day08.Operator.EQ
import io.dmitrijs.aoc2017.Day08.Operator.GT
import io.dmitrijs.aoc2017.Day08.Operator.GTE
import io.dmitrijs.aoc2017.Day08.Operator.LT
import io.dmitrijs.aoc2017.Day08.Operator.LTE
import io.dmitrijs.aoc2017.Day08.Operator.NEQ

class Day08(input: List<String>) {
    private val env = input.map { it.toExpr() }.fold(Environment()) { env, expr -> expr(env) }

    fun puzzle1() = env.maxValue

    fun puzzle2() = env.processMaxValue

    private data class Expr(
        private val name: String,
        private val func: String,
        private val delta: Int,
        private val predicate: Predicate,
    ) {
        operator fun invoke(env: Environment) =
            if (predicate(env)) env + (name to env[name] + delta * if (func == "inc") 1 else -1) else env
    }

    private data class Environment(private val vars: Map<String, Int> = emptyMap(), val processMaxValue: Int = 0) {
        val maxValue get() = vars.maxOf { (_, value) -> value }

        operator fun get(name: String) = vars[name] ?: 0

        operator fun plus(pair: Pair<String, Int>) = copy(
            vars = vars + pair,
            processMaxValue = maxOf(processMaxValue, pair.second),
        )
    }

    private data class Predicate(private val name: String, private val op: Operator, private val compare: Int) {
        operator fun invoke(env: Environment) = when (op) {
            GT -> env[name] > compare
            GTE -> env[name] >= compare
            LT -> env[name] < compare
            LTE -> env[name] <= compare
            EQ -> env[name] == compare
            NEQ -> env[name] != compare
        }

        companion object {
            fun of(input: String): Predicate {
                val (name, op, value) = input.split(" ")

                return Predicate(name, Operator.of(op), value.toInt())
            }
        }
    }

    private enum class Operator {
        GT, GTE, LT, LTE, EQ, NEQ;

        companion object {
            fun of(op: String) = when (op) {
                ">" -> GT
                ">=" -> GTE
                "<" -> LT
                "<=" -> LTE
                "==" -> EQ
                "!=" -> NEQ
                else -> error("Unsupported operation '$op'.")
            }
        }
    }

    private fun String.toExpr(): Expr {
        val (expr, predicate) = split(" if ")
        val (name, func, value) = expr.split(" ")

        return Expr(name, func, value.toInt(), Predicate.of(predicate))
    }
}
