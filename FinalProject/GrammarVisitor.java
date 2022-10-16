// Generated from C:/Users/Gebruiker/Desktop/Second Year CS/M6 Intelligent Interaction/Project/module8/pp/FinalProject/antlr\Grammar.g4 by ANTLR 4.9.1
package pp.FinalProject;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GrammarParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GrammarVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GrammarParser#comments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComments(GrammarParser.CommentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#classes}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClasses(GrammarParser.ClassesContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(GrammarParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBody(GrammarParser.BodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(GrammarParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#concurrentBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConcurrentBlock(GrammarParser.ConcurrentBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#lockCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLockCondition(GrammarParser.LockConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#funct}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunct(GrammarParser.FunctContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#return1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn1(GrammarParser.Return1Context ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_condition(GrammarParser.If_conditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#for_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_loop(GrammarParser.For_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#while_loop}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_loop(GrammarParser.While_loopContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(GrammarParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#multiple_conditions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiple_conditions(GrammarParser.Multiple_conditionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GrammarParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(GrammarParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Visit a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(GrammarParser.IdentifierContext ctx);
}