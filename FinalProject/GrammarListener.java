// Generated from C:/Users/Gebruiker/Desktop/Second Year CS/M6 Intelligent Interaction/Project/module8/pp/FinalProject/antlr\Grammar.g4 by ANTLR 4.9.1
package pp.FinalProject;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import pp.FinalProject.exceptions.LineException;
import pp.FinalProject.exceptions.TypeClassException;
import pp.FinalProject.exceptions.VariableException;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GrammarParser#comments}.
	 * @param ctx the parse tree
	 */
	void enterComments(GrammarParser.CommentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#comments}.
	 * @param ctx the parse tree
	 */
	void exitComments(GrammarParser.CommentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(GrammarParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#classes}.
	 * @param ctx the parse tree
	 */
	void enterClasses(GrammarParser.ClassesContext ctx) throws LineException;
	/**
	 * Exit a parse tree produced by {@link GrammarParser#classes}.
	 * @param ctx the parse tree
	 */
	void exitClasses(GrammarParser.ClassesContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(GrammarParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(GrammarParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void enterBody(GrammarParser.BodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#body}.
	 * @param ctx the parse tree
	 */
	void exitBody(GrammarParser.BodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(GrammarParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(GrammarParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#concurrentBlock}.
	 * @param ctx the parse tree
	 */
	void enterConcurrentBlock(GrammarParser.ConcurrentBlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#concurrentBlock}.
	 * @param ctx the parse tree
	 */
	void exitConcurrentBlock(GrammarParser.ConcurrentBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#lockCondition}.
	 * @param ctx the parse tree
	 */
	void enterLockCondition(GrammarParser.LockConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#lockCondition}.
	 * @param ctx the parse tree
	 */
	void exitLockCondition(GrammarParser.LockConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#funct}.
	 * @param ctx the parse tree
	 */
	void enterFunct(GrammarParser.FunctContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#funct}.
	 * @param ctx the parse tree
	 */
	void exitFunct(GrammarParser.FunctContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#return1}.
	 * @param ctx the parse tree
	 */
	void enterReturn1(GrammarParser.Return1Context ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#return1}.
	 * @param ctx the parse tree
	 */
	void exitReturn1(GrammarParser.Return1Context ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void enterPrint(GrammarParser.PrintContext ctx) throws VariableException;
	/**
	 * Exit a parse tree produced by {@link GrammarParser#print}.
	 * @param ctx the parse tree
	 */
	void exitPrint(GrammarParser.PrintContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void enterIf_condition(GrammarParser.If_conditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#if_condition}.
	 * @param ctx the parse tree
	 */
	void exitIf_condition(GrammarParser.If_conditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void enterFor_loop(GrammarParser.For_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#for_loop}.
	 * @param ctx the parse tree
	 */
	void exitFor_loop(GrammarParser.For_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void enterWhile_loop(GrammarParser.While_loopContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#while_loop}.
	 * @param ctx the parse tree
	 */
	void exitWhile_loop(GrammarParser.While_loopContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GrammarParser.DeclarationContext ctx) throws LineException, TypeClassException;
	/**
	 * Exit a parse tree produced by {@link GrammarParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GrammarParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GrammarParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(GrammarParser.ConditionContext ctx) throws VariableException, LineException;
	/**
	 * Exit a parse tree produced by {@link GrammarParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(GrammarParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#multiple_conditions}.
	 * @param ctx the parse tree
	 */
	void enterMultiple_conditions(GrammarParser.Multiple_conditionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#multiple_conditions}.
	 * @param ctx the parse tree
	 */
	void exitMultiple_conditions(GrammarParser.Multiple_conditionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(GrammarParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(GrammarParser.VariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(GrammarParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(GrammarParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void enterInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link GrammarParser#integer}.
	 * @param ctx the parse tree
	 */
	void exitInteger(GrammarParser.IntegerContext ctx);
	/**
	 * Enter a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void enterIdentifier(GrammarParser.IdentifierContext ctx) throws LineException;
	/**
	 * Exit a parse tree produced by {@link GrammarParser#identifier}.
	 * @param ctx the parse tree
	 */
	void exitIdentifier(GrammarParser.IdentifierContext ctx);
}