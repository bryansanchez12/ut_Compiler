// Generated from C:/Users/Gebruiker/Desktop/Second Year CS/M6 Intelligent Interaction/Project/module8/pp/FinalProject/antlr\Grammar.g4 by ANTLR 4.9.1
package pp.FinalProject;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GrammarLexer extends Lexer {
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
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
			"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "INT", "ARRAY", 
			"BOOLEAN", "CLASS", "STATE", "STRING", "MCOND", "GLOBAL_INTEGER", "GLOBAL_BOOLEAN", 
			"GLOBAL_ARRAY", "GLOBAL_STRING", "INTEGER", "IDENTIFIER", "WHITESPACE", 
			"COMMENT", "MULTILINE_COMMENT", "END", "OPERATORS", "COMPARATIVES", "STARTFUNC", 
			"QUOTES", "OPENBRT", "CLOSEBRT", "GLOBAL"
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


	public GrammarLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Grammar.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u014d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3"+
		"\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\25\5\25\u00b6\n\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\27"+
		"\3\27\3\27\3\27\3\27\5\27\u00c4\n\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32\3\32"+
		"\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\6\34\u00f8\n\34\r\34\16\34\u00f9\3\35\3\35\7\35\u00fe\n\35\f\35"+
		"\16\35\u0101\13\35\3\36\6\36\u0104\n\36\r\36\16\36\u0105\3\36\3\36\3\37"+
		"\3\37\3\37\3\37\7\37\u010e\n\37\f\37\16\37\u0111\13\37\3\37\3\37\3\37"+
		"\3\37\3 \3 \3 \3 \3 \7 \u011c\n \f \16 \u011f\13 \3 \3 \3 \3 \3 \3 \3"+
		"!\3!\3\"\3\"\3\"\3\"\3\"\5\"\u012e\n\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
		"#\3#\3#\5#\u013d\n#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3(\3(\3(\3(\4\u010f"+
		"\u011d\2)\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33"+
		"\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67"+
		"\359\36;\37= ?!A\"C#E$G%I&K\'M(O)\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\"+
		"aac|\5\2\13\f\17\17\"\"\5\2,-//\61\61\4\2>>@@\2\u015b\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K"+
		"\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\tW\3\2"+
		"\2\2\13Y\3\2\2\2\r[\3\2\2\2\17d\3\2\2\2\21i\3\2\2\2\23m\3\2\2\2\25t\3"+
		"\2\2\2\27z\3\2\2\2\31}\3\2\2\2\33\u0085\3\2\2\2\35\u008a\3\2\2\2\37\u008e"+
		"\3\2\2\2!\u0094\3\2\2\2#\u0098\3\2\2\2%\u009e\3\2\2\2\'\u00a6\3\2\2\2"+
		")\u00b5\3\2\2\2+\u00b7\3\2\2\2-\u00c3\3\2\2\2/\u00c5\3\2\2\2\61\u00cf"+
		"\3\2\2\2\63\u00dd\3\2\2\2\65\u00e9\3\2\2\2\67\u00f7\3\2\2\29\u00fb\3\2"+
		"\2\2;\u0103\3\2\2\2=\u0109\3\2\2\2?\u0116\3\2\2\2A\u0126\3\2\2\2C\u012d"+
		"\3\2\2\2E\u013c\3\2\2\2G\u013e\3\2\2\2I\u0140\3\2\2\2K\u0142\3\2\2\2M"+
		"\u0144\3\2\2\2O\u0146\3\2\2\2QR\7*\2\2R\4\3\2\2\2ST\7.\2\2T\6\3\2\2\2"+
		"UV\7+\2\2V\b\3\2\2\2WX\7}\2\2X\n\3\2\2\2YZ\7\177\2\2Z\f\3\2\2\2[\\\7r"+
		"\2\2\\]\7c\2\2]^\7t\2\2^_\7d\2\2_`\7g\2\2`a\7i\2\2ab\7k\2\2bc\7p\2\2c"+
		"\16\3\2\2\2de\7n\2\2ef\7q\2\2fg\7e\2\2gh\7m\2\2h\20\3\2\2\2ij\7f\2\2j"+
		"k\7g\2\2kl\7h\2\2l\22\3\2\2\2mn\7t\2\2no\7g\2\2op\7v\2\2pq\7w\2\2qr\7"+
		"t\2\2rs\7p\2\2s\24\3\2\2\2tu\7r\2\2uv\7t\2\2vw\7k\2\2wx\7p\2\2xy\7v\2"+
		"\2y\26\3\2\2\2z{\7k\2\2{|\7h\2\2|\30\3\2\2\2}~\7g\2\2~\177\7n\2\2\177"+
		"\u0080\7u\2\2\u0080\u0081\7g\2\2\u0081\u0082\7\"\2\2\u0082\u0083\7k\2"+
		"\2\u0083\u0084\7h\2\2\u0084\32\3\2\2\2\u0085\u0086\7g\2\2\u0086\u0087"+
		"\7n\2\2\u0087\u0088\7u\2\2\u0088\u0089\7g\2\2\u0089\34\3\2\2\2\u008a\u008b"+
		"\7h\2\2\u008b\u008c\7q\2\2\u008c\u008d\7t\2\2\u008d\36\3\2\2\2\u008e\u008f"+
		"\7y\2\2\u008f\u0090\7j\2\2\u0090\u0091\7k\2\2\u0091\u0092\7n\2\2\u0092"+
		"\u0093\7g\2\2\u0093 \3\2\2\2\u0094\u0095\7k\2\2\u0095\u0096\7p\2\2\u0096"+
		"\u0097\7v\2\2\u0097\"\3\2\2\2\u0098\u0099\7c\2\2\u0099\u009a\7t\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7c\2\2\u009c\u009d\7{\2\2\u009d$\3\2\2\2\u009e"+
		"\u009f\7d\2\2\u009f\u00a0\7q\2\2\u00a0\u00a1\7q\2\2\u00a1\u00a2\7n\2\2"+
		"\u00a2\u00a3\7g\2\2\u00a3\u00a4\7c\2\2\u00a4\u00a5\7p\2\2\u00a5&\3\2\2"+
		"\2\u00a6\u00a7\7e\2\2\u00a7\u00a8\7n\2\2\u00a8\u00a9\7c\2\2\u00a9\u00aa"+
		"\7u\2\2\u00aa\u00ab\7u\2\2\u00ab(\3\2\2\2\u00ac\u00ad\7V\2\2\u00ad\u00ae"+
		"\7t\2\2\u00ae\u00af\7w\2\2\u00af\u00b6\7g\2\2\u00b0\u00b1\7H\2\2\u00b1"+
		"\u00b2\7c\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7u\2\2\u00b4\u00b6\7g\2\2"+
		"\u00b5\u00ac\3\2\2\2\u00b5\u00b0\3\2\2\2\u00b6*\3\2\2\2\u00b7\u00b8\7"+
		"u\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7t\2\2\u00ba\u00bb\7k\2\2\u00bb\u00bc"+
		"\7p\2\2\u00bc\u00bd\7i\2\2\u00bd,\3\2\2\2\u00be\u00bf\7c\2\2\u00bf\u00c0"+
		"\7p\2\2\u00c0\u00c4\7f\2\2\u00c1\u00c2\7q\2\2\u00c2\u00c4\7t\2\2\u00c3"+
		"\u00be\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4.\3\2\2\2\u00c5\u00c6\7i\2\2\u00c6"+
		"\u00c7\7n\2\2\u00c7\u00c8\7q\2\2\u00c8\u00c9\7d\2\2\u00c9\u00ca\7c\2\2"+
		"\u00ca\u00cb\7n\2\2\u00cb\u00cc\7K\2\2\u00cc\u00cd\7p\2\2\u00cd\u00ce"+
		"\7v\2\2\u00ce\60\3\2\2\2\u00cf\u00d0\7i\2\2\u00d0\u00d1\7n\2\2\u00d1\u00d2"+
		"\7q\2\2\u00d2\u00d3\7d\2\2\u00d3\u00d4\7c\2\2\u00d4\u00d5\7n\2\2\u00d5"+
		"\u00d6\7D\2\2\u00d6\u00d7\7q\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7n\2\2"+
		"\u00d9\u00da\7g\2\2\u00da\u00db\7c\2\2\u00db\u00dc\7p\2\2\u00dc\62\3\2"+
		"\2\2\u00dd\u00de\7i\2\2\u00de\u00df\7n\2\2\u00df\u00e0\7q\2\2\u00e0\u00e1"+
		"\7d\2\2\u00e1\u00e2\7c\2\2\u00e2\u00e3\7n\2\2\u00e3\u00e4\7C\2\2\u00e4"+
		"\u00e5\7t\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7c\2\2\u00e7\u00e8\7{\2\2"+
		"\u00e8\64\3\2\2\2\u00e9\u00ea\7i\2\2\u00ea\u00eb\7n\2\2\u00eb\u00ec\7"+
		"q\2\2\u00ec\u00ed\7d\2\2\u00ed\u00ee\7c\2\2\u00ee\u00ef\7n\2\2\u00ef\u00f0"+
		"\7U\2\2\u00f0\u00f1\7v\2\2\u00f1\u00f2\7t\2\2\u00f2\u00f3\7k\2\2\u00f3"+
		"\u00f4\7p\2\2\u00f4\u00f5\7i\2\2\u00f5\66\3\2\2\2\u00f6\u00f8\t\2\2\2"+
		"\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa8\3\2\2\2\u00fb\u00ff\t\3\2\2\u00fc\u00fe\t\4\2\2\u00fd"+
		"\u00fc\3\2\2\2\u00fe\u0101\3\2\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2"+
		"\2\2\u0100:\3\2\2\2\u0101\u00ff\3\2\2\2\u0102\u0104\t\5\2\2\u0103\u0102"+
		"\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\u0108\b\36\2\2\u0108<\3\2\2\2\u0109\u010a\7/\2\2"+
		"\u010a\u010b\7/\2\2\u010b\u010f\3\2\2\2\u010c\u010e\13\2\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"\u0112\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0113\7\f\2\2\u0113\u0114\3\2"+
		"\2\2\u0114\u0115\b\37\2\2\u0115>\3\2\2\2\u0116\u0117\7/\2\2\u0117\u0118"+
		"\7/\2\2\u0118\u0119\7,\2\2\u0119\u011d\3\2\2\2\u011a\u011c\13\2\2\2\u011b"+
		"\u011a\3\2\2\2\u011c\u011f\3\2\2\2\u011d\u011e\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u0120\3\2\2\2\u011f\u011d\3\2\2\2\u0120\u0121\7,\2\2\u0121"+
		"\u0122\7/\2\2\u0122\u0123\7/\2\2\u0123\u0124\3\2\2\2\u0124\u0125\b \2"+
		"\2\u0125@\3\2\2\2\u0126\u0127\7=\2\2\u0127B\3\2\2\2\u0128\u012e\t\6\2"+
		"\2\u0129\u012a\7~\2\2\u012a\u012e\7~\2\2\u012b\u012c\7(\2\2\u012c\u012e"+
		"\7(\2\2\u012d\u0128\3\2\2\2\u012d\u0129\3\2\2\2\u012d\u012b\3\2\2\2\u012e"+
		"D\3\2\2\2\u012f\u013d\t\7\2\2\u0130\u0131\7?\2\2\u0131\u013d\7?\2\2\u0132"+
		"\u0133\7#\2\2\u0133\u013d\7?\2\2\u0134\u0135\7@\2\2\u0135\u013d\7?\2\2"+
		"\u0136\u0137\7>\2\2\u0137\u013d\7?\2\2\u0138\u0139\7~\2\2\u0139\u013d"+
		"\7~\2\2\u013a\u013b\7(\2\2\u013b\u013d\7(\2\2\u013c\u012f\3\2\2\2\u013c"+
		"\u0130\3\2\2\2\u013c\u0132\3\2\2\2\u013c\u0134\3\2\2\2\u013c\u0136\3\2"+
		"\2\2\u013c\u0138\3\2\2\2\u013c\u013a\3\2\2\2\u013dF\3\2\2\2\u013e\u013f"+
		"\7?\2\2\u013fH\3\2\2\2\u0140\u0141\7$\2\2\u0141J\3\2\2\2\u0142\u0143\7"+
		"]\2\2\u0143L\3\2\2\2\u0144\u0145\7_\2\2\u0145N\3\2\2\2\u0146\u0147\7i"+
		"\2\2\u0147\u0148\7n\2\2\u0148\u0149\7q\2\2\u0149\u014a\7d\2\2\u014a\u014b"+
		"\7c\2\2\u014b\u014c\7n\2\2\u014cP\3\2\2\2\f\2\u00b5\u00c3\u00f9\u00ff"+
		"\u0105\u010f\u011d\u012d\u013c\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}