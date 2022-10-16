// Generated from C:/Users/Gebruiker/Desktop/Second Year CS/M6 Intelligent Interaction/Project/module8/pp/FinalProject/antlr\Grammar.g4 by ANTLR 4.9.1
package pp.FinalProject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.ParserATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTreeListener;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;
import org.antlr.v4.runtime.tree.TerminalNode;
import pp.FinalProject.exceptions.LineException;
import pp.FinalProject.exceptions.TypeClassException;
import pp.FinalProject.exceptions.VariableException;

import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, INT=16, ARRAY=17, 
		BOOLEAN=18, CLASS=19, STATE=20, STRING=21, MCOND=22, GLOBAL_INTEGER=23, 
		GLOBAL_BOOLEAN=24, GLOBAL_ARRAY=25, GLOBAL_STRING=26, INTEGER=27, IDENTIFIER=28, 
		WHITESPACE=29, COMMENT=30, MULTILINE_COMMENT=31, END=32, OPERATORS=33, 
		COMPARATIVES=34, STARTFUNC=35, QUOTES=36, OPENBRT=37, CLOSEBRT=38, GLOBAL=39;
	public static final int
		RULE_comments = 0, RULE_program = 1, RULE_classes = 2, RULE_arguments = 3, 
		RULE_body = 4, RULE_statements = 5, RULE_concurrentBlock = 6, RULE_lockCondition = 7, 
		RULE_funct = 8, RULE_return1 = 9, RULE_print = 10, RULE_if_condition = 11, 
		RULE_for_loop = 12, RULE_while_loop = 13, RULE_declaration = 14, RULE_expression = 15, 
		RULE_condition = 16, RULE_multiple_conditions = 17, RULE_variable = 18, 
		RULE_type = 19, RULE_integer = 20, RULE_identifier = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"comments", "program", "classes", "arguments", "body", "statements", 
			"concurrentBlock", "lockCondition", "funct", "return1", "print", "if_condition", 
			"for_loop", "while_loop", "declaration", "expression", "condition", "multiple_conditions", 
			"variable", "type", "integer", "identifier"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'('", "','", "')'", "'{'", "'}'", "'parbegin'", "'lock'", "'def'", 
			"'return'", "'print'", "'if'", "'else if'", "'else'", "'for'", "'while'", 
			"'int'", "'array'", "'boolean'", "'class'", null, "'string'", null, "'globalInt'", 
			"'globalBoolean'", "'globalArray'", "'globalString'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, null, null, "INT", "ARRAY", "BOOLEAN", "CLASS", "STATE", 
			"STRING", "MCOND", "GLOBAL_INTEGER", "GLOBAL_BOOLEAN", "GLOBAL_ARRAY", 
			"GLOBAL_STRING", "INTEGER", "IDENTIFIER", "WHITESPACE", "COMMENT", "MULTILINE_COMMENT", 
			"END", "OPERATORS", "COMPARATIVES", "STARTFUNC", "QUOTES", "OPENBRT", 
			"CLOSEBRT", "GLOBAL"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GrammarParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CommentsContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public TerminalNode EOF() { return getToken(GrammarParser.EOF, 0); }
		public CommentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterComments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitComments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitComments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommentsContext comments() throws RecognitionException {
		CommentsContext _localctx = new CommentsContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_comments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(44);
			program();
			setState(45);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public List<ClassesContext> classes() {
			return getRuleContexts(ClassesContext.class);
		}
		public ClassesContext classes(int i) {
			return getRuleContext(ClassesContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(GrammarParser.END); }
		public TerminalNode END(int i) {
			return getToken(GrammarParser.END, i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING))) != 0)) {
				{
				{
				setState(47);
				classes();
				setState(48);
				match(END);
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassesContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public ClassesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) {
                try {
                    ((GrammarListener)listener).enterClasses(this);
                } catch (LineException e) {
                    e.printStackTrace();
                }
            }
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitClasses(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitClasses(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassesContext classes() throws RecognitionException {
		ClassesContext _localctx = new ClassesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classes);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(55);
			type();
			setState(56);
			identifier();
			setState(57);
			arguments();
			setState(58);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentsContext extends ParserRuleContext {
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_arguments);
		int _la;
		try {
			setState(76);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(60);
				match(T__0);
				setState(72);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING))) != 0)) {
					{
					setState(61);
					type();
					setState(62);
					identifier();
					setState(69);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==T__1) {
						{
						{
						setState(63);
						match(T__1);
						setState(64);
						type();
						setState(65);
						identifier();
						}
						}
						setState(71);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(74);
				match(T__2);
				}
				break;
			case T__3:
				enterOuterAlt(_localctx, 2);
				{
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BodyContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public List<FunctContext> funct() {
			return getRuleContexts(FunctContext.class);
		}
		public FunctContext funct(int i) {
			return getRuleContext(FunctContext.class,i);
		}
		public BodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_body; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterBody(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitBody(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BodyContext body() throws RecognitionException {
		BodyContext _localctx = new BodyContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_body);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__3);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				setState(81);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case T__5:
				case T__6:
				case T__8:
				case T__9:
				case T__10:
				case T__13:
				case T__14:
				case INT:
				case ARRAY:
				case BOOLEAN:
				case CLASS:
				case STRING:
				case GLOBAL_INTEGER:
				case GLOBAL_BOOLEAN:
				case GLOBAL_ARRAY:
				case GLOBAL_STRING:
				case IDENTIFIER:
					{
					setState(79);
					statements();
					}
					break;
				case T__7:
					{
					setState(80);
					funct();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(85);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(86);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementsContext extends ParserRuleContext {
		public If_conditionContext if_condition() {
			return getRuleContext(If_conditionContext.class,0);
		}
		public TerminalNode END() { return getToken(GrammarParser.END, 0); }
		public While_loopContext while_loop() {
			return getRuleContext(While_loopContext.class,0);
		}
		public For_loopContext for_loop() {
			return getRuleContext(For_loopContext.class,0);
		}
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public Return1Context return1() {
			return getRuleContext(Return1Context.class,0);
		}
		public PrintContext print() {
			return getRuleContext(PrintContext.class,0);
		}
		public ConcurrentBlockContext concurrentBlock() {
			return getRuleContext(ConcurrentBlockContext.class,0);
		}
		public LockConditionContext lockCondition() {
			return getRuleContext(LockConditionContext.class,0);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterStatements(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitStatements(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_statements);
		try {
			setState(112);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__10:
				enterOuterAlt(_localctx, 1);
				{
				setState(88);
				if_condition();
				setState(89);
				match(END);
				}
				break;
			case T__14:
				enterOuterAlt(_localctx, 2);
				{
				setState(91);
				while_loop();
				setState(92);
				match(END);
				}
				break;
			case T__13:
				enterOuterAlt(_localctx, 3);
				{
				setState(94);
				for_loop();
				setState(95);
				match(END);
				}
				break;
			case INT:
			case ARRAY:
			case BOOLEAN:
			case CLASS:
			case STRING:
			case GLOBAL_INTEGER:
			case GLOBAL_BOOLEAN:
			case GLOBAL_ARRAY:
			case GLOBAL_STRING:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 4);
				{
				setState(97);
				declaration();
				setState(98);
				match(END);
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 5);
				{
				setState(100);
				return1();
				setState(101);
				match(END);
				}
				break;
			case T__9:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				print();
				setState(104);
				match(END);
				}
				break;
			case T__5:
				enterOuterAlt(_localctx, 7);
				{
				setState(106);
				concurrentBlock();
				setState(107);
				match(END);
				}
				break;
			case T__6:
				enterOuterAlt(_localctx, 8);
				{
				setState(109);
				lockCondition();
				setState(110);
				match(END);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConcurrentBlockContext extends ParserRuleContext {
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public ConcurrentBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_concurrentBlock; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterConcurrentBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitConcurrentBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitConcurrentBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConcurrentBlockContext concurrentBlock() throws RecognitionException {
		ConcurrentBlockContext _localctx = new ConcurrentBlockContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_concurrentBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(T__5);
			setState(115);
			match(T__3);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(116);
				statements();
				}
				}
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(122);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class LockConditionContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<StatementsContext> statements() {
			return getRuleContexts(StatementsContext.class);
		}
		public StatementsContext statements(int i) {
			return getRuleContext(StatementsContext.class,i);
		}
		public LockConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lockCondition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterLockCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitLockCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitLockCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LockConditionContext lockCondition() throws RecognitionException {
		LockConditionContext _localctx = new LockConditionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_lockCondition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(124);
			match(T__6);
			setState(125);
			match(T__0);
			setState(126);
			identifier();
			setState(127);
			match(T__2);
			setState(128);
			match(T__3);
			setState(132);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__5) | (1L << T__6) | (1L << T__8) | (1L << T__9) | (1L << T__10) | (1L << T__13) | (1L << T__14) | (1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING) | (1L << IDENTIFIER))) != 0)) {
				{
				{
				setState(129);
				statements();
				}
				}
				setState(134);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(135);
			match(T__4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public TerminalNode END() { return getToken(GrammarParser.END, 0); }
		public FunctContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_funct; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterFunct(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitFunct(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitFunct(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctContext funct() throws RecognitionException {
		FunctContext _localctx = new FunctContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_funct);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(T__7);
			setState(138);
			identifier();
			setState(139);
			arguments();
			setState(140);
			body();
			setState(141);
			match(END);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Return1Context extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public Return1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_return1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterReturn1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitReturn1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitReturn1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Return1Context return1() throws RecognitionException {
		Return1Context _localctx = new Return1Context(_ctx, getState());
		enterRule(_localctx, 18, RULE_return1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(T__8);
			setState(144);
			variable();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PrintContext extends ParserRuleContext {
		public VariableContext variable() {
			return getRuleContext(VariableContext.class,0);
		}
		public PrintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_print; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) {
                try {
                    ((GrammarListener)listener).enterPrint(this);
                } catch (VariableException e) {
                    e.printStackTrace();
                }
            }
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitPrint(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitPrint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrintContext print() throws RecognitionException {
		PrintContext _localctx = new PrintContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_print);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(146);
			match(T__9);
			setState(147);
			match(T__0);
			setState(148);
			variable();
			setState(149);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class If_conditionContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<BodyContext> body() {
			return getRuleContexts(BodyContext.class);
		}
		public BodyContext body(int i) {
			return getRuleContext(BodyContext.class,i);
		}
		public If_conditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_if_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterIf_condition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitIf_condition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitIf_condition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final If_conditionContext if_condition() throws RecognitionException {
		If_conditionContext _localctx = new If_conditionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_if_condition);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(151);
			match(T__10);
			setState(152);
			match(T__0);
			setState(153);
			condition();
			setState(154);
			match(T__2);
			setState(155);
			body();
			setState(164);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(156);
				match(T__11);
				setState(157);
				match(T__0);
				setState(158);
				condition();
				setState(159);
				match(T__2);
				setState(160);
				body();
				}
				}
				setState(166);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__12) {
				{
				setState(167);
				match(T__12);
				setState(168);
				body();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class For_loopContext extends ParserRuleContext {
		public List<DeclarationContext> declaration() {
			return getRuleContexts(DeclarationContext.class);
		}
		public DeclarationContext declaration(int i) {
			return getRuleContext(DeclarationContext.class,i);
		}
		public List<TerminalNode> END() { return getTokens(GrammarParser.END); }
		public TerminalNode END(int i) {
			return getToken(GrammarParser.END, i);
		}
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public For_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_for_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterFor_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitFor_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitFor_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final For_loopContext for_loop() throws RecognitionException {
		For_loopContext _localctx = new For_loopContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_for_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			match(T__13);
			setState(172);
			match(T__0);
			setState(173);
			declaration();
			setState(174);
			match(END);
			setState(175);
			condition();
			setState(176);
			match(END);
			setState(177);
			declaration();
			setState(178);
			match(T__2);
			setState(179);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class While_loopContext extends ParserRuleContext {
		public ConditionContext condition() {
			return getRuleContext(ConditionContext.class,0);
		}
		public BodyContext body() {
			return getRuleContext(BodyContext.class,0);
		}
		public While_loopContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_while_loop; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterWhile_loop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitWhile_loop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitWhile_loop(this);
			else return visitor.visitChildren(this);
		}
	}

	public final While_loopContext while_loop() throws RecognitionException {
		While_loopContext _localctx = new While_loopContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_while_loop);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(181);
			match(T__14);
			setState(182);
			match(T__0);
			setState(183);
			condition();
			setState(184);
			match(T__2);
			setState(185);
			body();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STARTFUNC() { return getToken(GrammarParser.STARTFUNC, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) {
                try {
                    ((GrammarListener)listener).enterDeclaration(this);
                } catch (LineException e) {
                    e.printStackTrace();
                } catch (TypeClassException e) {
                    e.printStackTrace();
                }
            }
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_declaration);
		try {
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INT:
			case ARRAY:
			case BOOLEAN:
			case CLASS:
			case STRING:
			case GLOBAL_INTEGER:
			case GLOBAL_BOOLEAN:
			case GLOBAL_ARRAY:
			case GLOBAL_STRING:
				enterOuterAlt(_localctx, 1);
				{
				setState(187);
				type();
				setState(188);
				identifier();
				setState(189);
				match(STARTFUNC);
				setState(190);
				expression();
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(192);
				identifier();
				setState(193);
				match(STARTFUNC);
				setState(194);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public List<TerminalNode> OPERATORS() { return getTokens(GrammarParser.OPERATORS); }
		public TerminalNode OPERATORS(int i) {
			return getToken(GrammarParser.OPERATORS, i);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expression);
		int _la;
		try {
			setState(210);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				match(T__0);
				setState(199);
				expression();
				setState(200);
				match(T__2);
				}
				break;
			case T__2:
			case STATE:
			case INTEGER:
			case IDENTIFIER:
			case END:
			case OPERATORS:
			case QUOTES:
			case OPENBRT:
				enterOuterAlt(_localctx, 2);
				{
				setState(202);
				variable();
				setState(207);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==OPERATORS) {
					{
					{
					setState(203);
					match(OPERATORS);
					setState(204);
					variable();
					}
					}
					setState(209);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConditionContext extends ParserRuleContext {
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode COMPARATIVES() { return getToken(GrammarParser.COMPARATIVES, 0); }
		public Multiple_conditionsContext multiple_conditions() {
			return getRuleContext(Multiple_conditionsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode STATE() { return getToken(GrammarParser.STATE, 0); }
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) {
                try {
                    ((GrammarListener)listener).enterCondition(this);
                } catch (VariableException e) {
                    e.printStackTrace();
                } catch (LineException e) {
                    e.printStackTrace();
                }
            }
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_condition);
		try {
			setState(219);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(212);
				variable();
				setState(213);
				match(COMPARATIVES);
				setState(214);
				variable();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(216);
				multiple_conditions();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(217);
				identifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(218);
				match(STATE);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Multiple_conditionsContext extends ParserRuleContext {
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public List<TerminalNode> MCOND() { return getTokens(GrammarParser.MCOND); }
		public TerminalNode MCOND(int i) {
			return getToken(GrammarParser.MCOND, i);
		}
		public Multiple_conditionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiple_conditions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterMultiple_conditions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitMultiple_conditions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitMultiple_conditions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Multiple_conditionsContext multiple_conditions() throws RecognitionException {
		Multiple_conditionsContext _localctx = new Multiple_conditionsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_multiple_conditions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(221);
			match(T__0);
			setState(222);
			condition();
			setState(223);
			match(T__2);
			setState(229); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(224);
				match(MCOND);
				setState(225);
				match(T__0);
				setState(226);
				condition();
				setState(227);
				match(T__2);
				}
				}
				setState(231); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==MCOND );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableContext extends ParserRuleContext {
		public List<TerminalNode> QUOTES() { return getTokens(GrammarParser.QUOTES); }
		public TerminalNode QUOTES(int i) {
			return getToken(GrammarParser.QUOTES, i);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode OPENBRT() { return getToken(GrammarParser.OPENBRT, 0); }
		public List<VariableContext> variable() {
			return getRuleContexts(VariableContext.class);
		}
		public VariableContext variable(int i) {
			return getRuleContext(VariableContext.class,i);
		}
		public TerminalNode CLOSEBRT() { return getToken(GrammarParser.CLOSEBRT, 0); }
		public IntegerContext integer() {
			return getRuleContext(IntegerContext.class,0);
		}
		public TerminalNode STATE() { return getToken(GrammarParser.STATE, 0); }
		public VariableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterVariable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitVariable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableContext variable() throws RecognitionException {
		VariableContext _localctx = new VariableContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_variable);
		int _la;
		try {
			setState(252);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUOTES:
				enterOuterAlt(_localctx, 1);
				{
				setState(233);
				match(QUOTES);
				setState(234);
				identifier();
				setState(235);
				match(QUOTES);
				}
				break;
			case OPENBRT:
				enterOuterAlt(_localctx, 2);
				{
				setState(237);
				match(OPENBRT);
				setState(238);
				variable();
				setState(243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==T__1) {
					{
					{
					setState(239);
					match(T__1);
					setState(240);
					variable();
					}
					}
					setState(245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(246);
				match(CLOSEBRT);
				}
				break;
			case IDENTIFIER:
				enterOuterAlt(_localctx, 3);
				{
				setState(248);
				identifier();
				}
				break;
			case INTEGER:
				enterOuterAlt(_localctx, 4);
				{
				setState(249);
				integer();
				}
				break;
			case T__1:
			case T__2:
			case END:
			case OPERATORS:
			case COMPARATIVES:
			case CLOSEBRT:
				enterOuterAlt(_localctx, 5);
				{
				}
				break;
			case STATE:
				enterOuterAlt(_localctx, 6);
				{
				setState(251);
				match(STATE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(GrammarParser.BOOLEAN, 0); }
		public TerminalNode INT() { return getToken(GrammarParser.INT, 0); }
		public TerminalNode ARRAY() { return getToken(GrammarParser.ARRAY, 0); }
		public TerminalNode CLASS() { return getToken(GrammarParser.CLASS, 0); }
		public TerminalNode STRING() { return getToken(GrammarParser.STRING, 0); }
		public TerminalNode GLOBAL_INTEGER() { return getToken(GrammarParser.GLOBAL_INTEGER, 0); }
		public TerminalNode GLOBAL_BOOLEAN() { return getToken(GrammarParser.GLOBAL_BOOLEAN, 0); }
		public TerminalNode GLOBAL_ARRAY() { return getToken(GrammarParser.GLOBAL_ARRAY, 0); }
		public TerminalNode GLOBAL_STRING() { return getToken(GrammarParser.GLOBAL_STRING, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << INT) | (1L << ARRAY) | (1L << BOOLEAN) | (1L << CLASS) | (1L << STRING) | (1L << GLOBAL_INTEGER) | (1L << GLOBAL_BOOLEAN) | (1L << GLOBAL_ARRAY) | (1L << GLOBAL_STRING))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(GrammarParser.INTEGER, 0); }
		public IntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integer; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).enterInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitInteger(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitInteger(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IntegerContext integer() throws RecognitionException {
		IntegerContext _localctx = new IntegerContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_integer);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(INTEGER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(GrammarParser.IDENTIFIER, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) {
                try {
                    ((GrammarListener)listener).enterIdentifier(this);
                } catch (LineException e) {
                    e.printStackTrace();
                }
            }
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GrammarListener) ((GrammarListener)listener).exitIdentifier(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GrammarVisitor) return ((GrammarVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_identifier);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(258);
			match(IDENTIFIER);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3)\u0107\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\3\3\3"+
		"\3\3\7\3\65\n\3\f\3\16\38\13\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5"+
		"\3\5\3\5\7\5F\n\5\f\5\16\5I\13\5\5\5K\n\5\3\5\3\5\5\5O\n\5\3\6\3\6\3\6"+
		"\7\6T\n\6\f\6\16\6W\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3"+
		"\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7s\n\7\3"+
		"\b\3\b\3\b\7\bx\n\b\f\b\16\b{\13\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\7\t"+
		"\u0085\n\t\f\t\16\t\u0088\13\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\7\r\u00a5\n\r\f\r\16\r\u00a8\13\r\3\r\3\r\5\r\u00ac\n\r\3\16\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00c7\n\20\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\7\21\u00d0\n\21\f\21\16\21\u00d3\13\21\5\21"+
		"\u00d5\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u00de\n\22\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\6\23\u00e8\n\23\r\23\16\23\u00e9\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00f4\n\24\f\24\16\24\u00f7\13"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\5\24\u00ff\n\24\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,"+
		"\2\3\5\2\22\25\27\27\31\34\2\u010e\2.\3\2\2\2\4\66\3\2\2\2\69\3\2\2\2"+
		"\bN\3\2\2\2\nP\3\2\2\2\fr\3\2\2\2\16t\3\2\2\2\20~\3\2\2\2\22\u008b\3\2"+
		"\2\2\24\u0091\3\2\2\2\26\u0094\3\2\2\2\30\u0099\3\2\2\2\32\u00ad\3\2\2"+
		"\2\34\u00b7\3\2\2\2\36\u00c6\3\2\2\2 \u00d4\3\2\2\2\"\u00dd\3\2\2\2$\u00df"+
		"\3\2\2\2&\u00fe\3\2\2\2(\u0100\3\2\2\2*\u0102\3\2\2\2,\u0104\3\2\2\2."+
		"/\5\4\3\2/\60\7\2\2\3\60\3\3\2\2\2\61\62\5\6\4\2\62\63\7\"\2\2\63\65\3"+
		"\2\2\2\64\61\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\67\5\3\2"+
		"\2\28\66\3\2\2\29:\5(\25\2:;\5,\27\2;<\5\b\5\2<=\5\n\6\2=\7\3\2\2\2>J"+
		"\7\3\2\2?@\5(\25\2@G\5,\27\2AB\7\4\2\2BC\5(\25\2CD\5,\27\2DF\3\2\2\2E"+
		"A\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3\2\2\2HK\3\2\2\2IG\3\2\2\2J?\3\2\2\2"+
		"JK\3\2\2\2KL\3\2\2\2LO\7\5\2\2MO\3\2\2\2N>\3\2\2\2NM\3\2\2\2O\t\3\2\2"+
		"\2PU\7\6\2\2QT\5\f\7\2RT\5\22\n\2SQ\3\2\2\2SR\3\2\2\2TW\3\2\2\2US\3\2"+
		"\2\2UV\3\2\2\2VX\3\2\2\2WU\3\2\2\2XY\7\7\2\2Y\13\3\2\2\2Z[\5\30\r\2[\\"+
		"\7\"\2\2\\s\3\2\2\2]^\5\34\17\2^_\7\"\2\2_s\3\2\2\2`a\5\32\16\2ab\7\""+
		"\2\2bs\3\2\2\2cd\5\36\20\2de\7\"\2\2es\3\2\2\2fg\5\24\13\2gh\7\"\2\2h"+
		"s\3\2\2\2ij\5\26\f\2jk\7\"\2\2ks\3\2\2\2lm\5\16\b\2mn\7\"\2\2ns\3\2\2"+
		"\2op\5\20\t\2pq\7\"\2\2qs\3\2\2\2rZ\3\2\2\2r]\3\2\2\2r`\3\2\2\2rc\3\2"+
		"\2\2rf\3\2\2\2ri\3\2\2\2rl\3\2\2\2ro\3\2\2\2s\r\3\2\2\2tu\7\b\2\2uy\7"+
		"\6\2\2vx\5\f\7\2wv\3\2\2\2x{\3\2\2\2yw\3\2\2\2yz\3\2\2\2z|\3\2\2\2{y\3"+
		"\2\2\2|}\7\7\2\2}\17\3\2\2\2~\177\7\t\2\2\177\u0080\7\3\2\2\u0080\u0081"+
		"\5,\27\2\u0081\u0082\7\5\2\2\u0082\u0086\7\6\2\2\u0083\u0085\5\f\7\2\u0084"+
		"\u0083\3\2\2\2\u0085\u0088\3\2\2\2\u0086\u0084\3\2\2\2\u0086\u0087\3\2"+
		"\2\2\u0087\u0089\3\2\2\2\u0088\u0086\3\2\2\2\u0089\u008a\7\7\2\2\u008a"+
		"\21\3\2\2\2\u008b\u008c\7\n\2\2\u008c\u008d\5,\27\2\u008d\u008e\5\b\5"+
		"\2\u008e\u008f\5\n\6\2\u008f\u0090\7\"\2\2\u0090\23\3\2\2\2\u0091\u0092"+
		"\7\13\2\2\u0092\u0093\5&\24\2\u0093\25\3\2\2\2\u0094\u0095\7\f\2\2\u0095"+
		"\u0096\7\3\2\2\u0096\u0097\5&\24\2\u0097\u0098\7\5\2\2\u0098\27\3\2\2"+
		"\2\u0099\u009a\7\r\2\2\u009a\u009b\7\3\2\2\u009b\u009c\5\"\22\2\u009c"+
		"\u009d\7\5\2\2\u009d\u00a6\5\n\6\2\u009e\u009f\7\16\2\2\u009f\u00a0\7"+
		"\3\2\2\u00a0\u00a1\5\"\22\2\u00a1\u00a2\7\5\2\2\u00a2\u00a3\5\n\6\2\u00a3"+
		"\u00a5\3\2\2\2\u00a4\u009e\3\2\2\2\u00a5\u00a8\3\2\2\2\u00a6\u00a4\3\2"+
		"\2\2\u00a6\u00a7\3\2\2\2\u00a7\u00ab\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9"+
		"\u00aa\7\17\2\2\u00aa\u00ac\5\n\6\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3"+
		"\2\2\2\u00ac\31\3\2\2\2\u00ad\u00ae\7\20\2\2\u00ae\u00af\7\3\2\2\u00af"+
		"\u00b0\5\36\20\2\u00b0\u00b1\7\"\2\2\u00b1\u00b2\5\"\22\2\u00b2\u00b3"+
		"\7\"\2\2\u00b3\u00b4\5\36\20\2\u00b4\u00b5\7\5\2\2\u00b5\u00b6\5\n\6\2"+
		"\u00b6\33\3\2\2\2\u00b7\u00b8\7\21\2\2\u00b8\u00b9\7\3\2\2\u00b9\u00ba"+
		"\5\"\22\2\u00ba\u00bb\7\5\2\2\u00bb\u00bc\5\n\6\2\u00bc\35\3\2\2\2\u00bd"+
		"\u00be\5(\25\2\u00be\u00bf\5,\27\2\u00bf\u00c0\7%\2\2\u00c0\u00c1\5 \21"+
		"\2\u00c1\u00c7\3\2\2\2\u00c2\u00c3\5,\27\2\u00c3\u00c4\7%\2\2\u00c4\u00c5"+
		"\5 \21\2\u00c5\u00c7\3\2\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c7"+
		"\37\3\2\2\2\u00c8\u00c9\7\3\2\2\u00c9\u00ca\5 \21\2\u00ca\u00cb\7\5\2"+
		"\2\u00cb\u00d5\3\2\2\2\u00cc\u00d1\5&\24\2\u00cd\u00ce\7#\2\2\u00ce\u00d0"+
		"\5&\24\2\u00cf\u00cd\3\2\2\2\u00d0\u00d3\3\2\2\2\u00d1\u00cf\3\2\2\2\u00d1"+
		"\u00d2\3\2\2\2\u00d2\u00d5\3\2\2\2\u00d3\u00d1\3\2\2\2\u00d4\u00c8\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d5!\3\2\2\2\u00d6\u00d7\5&\24\2\u00d7\u00d8"+
		"\7$\2\2\u00d8\u00d9\5&\24\2\u00d9\u00de\3\2\2\2\u00da\u00de\5$\23\2\u00db"+
		"\u00de\5,\27\2\u00dc\u00de\7\26\2\2\u00dd\u00d6\3\2\2\2\u00dd\u00da\3"+
		"\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00dc\3\2\2\2\u00de#\3\2\2\2\u00df\u00e0"+
		"\7\3\2\2\u00e0\u00e1\5\"\22\2\u00e1\u00e7\7\5\2\2\u00e2\u00e3\7\30\2\2"+
		"\u00e3\u00e4\7\3\2\2\u00e4\u00e5\5\"\22\2\u00e5\u00e6\7\5\2\2\u00e6\u00e8"+
		"\3\2\2\2\u00e7\u00e2\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9"+
		"\u00ea\3\2\2\2\u00ea%\3\2\2\2\u00eb\u00ec\7&\2\2\u00ec\u00ed\5,\27\2\u00ed"+
		"\u00ee\7&\2\2\u00ee\u00ff\3\2\2\2\u00ef\u00f0\7\'\2\2\u00f0\u00f5\5&\24"+
		"\2\u00f1\u00f2\7\4\2\2\u00f2\u00f4\5&\24\2\u00f3\u00f1\3\2\2\2\u00f4\u00f7"+
		"\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6\u00f8\3\2\2\2\u00f7"+
		"\u00f5\3\2\2\2\u00f8\u00f9\7(\2\2\u00f9\u00ff\3\2\2\2\u00fa\u00ff\5,\27"+
		"\2\u00fb\u00ff\5*\26\2\u00fc\u00ff\3\2\2\2\u00fd\u00ff\7\26\2\2\u00fe"+
		"\u00eb\3\2\2\2\u00fe\u00ef\3\2\2\2\u00fe\u00fa\3\2\2\2\u00fe\u00fb\3\2"+
		"\2\2\u00fe\u00fc\3\2\2\2\u00fe\u00fd\3\2\2\2\u00ff\'\3\2\2\2\u0100\u0101"+
		"\t\2\2\2\u0101)\3\2\2\2\u0102\u0103\7\35\2\2\u0103+\3\2\2\2\u0104\u0105"+
		"\7\36\2\2\u0105-\3\2\2\2\24\66GJNSUry\u0086\u00a6\u00ab\u00c6\u00d1\u00d4"+
		"\u00dd\u00e9\u00f5\u00fe";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}