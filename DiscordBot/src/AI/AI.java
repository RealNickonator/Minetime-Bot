package AI;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;


public class AI
{
    public static String[] verbs =
        	//{"attack", "jump", "run", "ran", "yell", "appear", "hop", "avoid", "annoy"};
        
        	{"accept", "add", "admire", "admit", "advise", "afford", "agree", "alert", "allow", "amuse", 
        	"analyze", "announce", "annoy", "answer", "apologise", "appear", "applaud", "appreciate", 
        	"approve", "argue", "arrange", "arrest", "arrive", "ask", "attach", "attack", "attempt", "attend", 
        	"attract", "avoid", "back", "bake", "balance", "ban", "bang", "bare", "bat", "bathe", "battle", 
        	"beam", "beg", "behave", "belong", "bleach", "bless", "blind", "blink", "blot", "blush", "boast", 
        	"boil", "bolt", "bomb", "book", "bore", "borrow", "bounce", "bow", "box", "brake", "branch", "breathe", 
        	"bruise", "brush", "bubble", "bump", "burn", "bury", "buzz", "calculate", "call", "camp", "care",
        	"carry", "carve", "cause", "challenge", "change", "charge", "chase", "cheat", "check", "cheer", 
        	"chew", "choke", "chop", "claim", "clap", "clean", "clear", "clip", "close", "coach", "coil", 
        	"collect", "colour", "comb", "command", "communicate", "compare", "compete", "complain", "complete", 
        	"concentrate", "concern", "confess", "confuse", "connect", "consider", "consist", "contain", 
        	"continue", "copy", "correct", "cough", "count", "cover", "crack", "crash", "crawl", "cross", "crush", 
        	"cry", "cure", "curl", "curve", "cycle", "dam", "damage", "dance", "dare", "decay", "deceive", 
        	"decide", "decorate", "delay", "delight", "deliver", "depend", "describe", "desert", "deserve", 
        	"destroy", "detect", "develop", "disagree", "disappear", "disapprove", "disarm", "discover", "dislike", 
        	"divide", "double", "doubt", "drag", "drain", "dream", "dress", "drip", "drop", "drown", "drum", 
        	"dry", "dust", "earn", "educate", "embarrass", "employ", "empty", "encourage", "end", "enjoy", "enter", 
        	"entertain", "escape", "examine", "excite", "excuse", "exercise", "exist", "expand", "expect", "explain", 
        	"explode", "extend", "face", "fade", "fail", "fancy", "fasten", "fax", "fear", "fence", "fetch", 
        	"file", "fill", "film", "fire", "fit", "fix", "flap", "flash", "float", "flood", "flow", "flower", "fold", 
        	"follow", "fool", "force", "form", "found", "frame", "frighten", "fry", "gather", "gaze", "glow", 
        	"glue", "grab", "grate", "grease", "greet", "grin", "grip", "groan", "guarantee", "guard", "guess", 
        	"guide", "hammer", "hand", "handle", "hang", "happen", "harass", "harm", "hate", "haunt", "head", "heal", 
        	"heap", "heat", "help", "hook", "hop", "hope", "hover", "hug", "hum", "hunt", "hurry", "identify", 
        	"ignore", "imagine", "impress", "improve", "include", "increase", "influence", "inform", "inject", "injure", 
        	"instruct", "intend", "interest", "interfere", "interrupt", "introduce", "invent", "invite", "irritate", 
        	"itch", "jail", "jam", "jog", "join", "joke", "judge", "juggle", "jump", "kick", "kill", "kiss", "kneel",
        	"knit", "knock", "knot", "label", "land", "last", "laugh", "launch", "learn", "level", "license", "lick",
        	"lie", "lighten", "like", "list", "listen", "live", "load", "lock", "long", "look", "love", "man", "manage",
        	"march", "mark", "marry", "match", "mate", "matter", "measure", "meddle", "melt", "memorise", "mend", 
        	"mess-up", "milk", "mine", "miss", "mix", "moan", "moor", "mourn", "move", "muddle", "mug", "multiply", 
        	"murder", "nail", "name", "need", "nest", "nod", "note", "notice", "number", "obey", "object", "observe",
        	"obtain", "occur", "offend", "offer", "open", "order", "overflow", "owe", "own", "pack", "paddle", "paint", 
        	"park", "part", "pass", "paste", "pat", "pause", "peck", "pedal", "peel", "peep", "perform", "permit", "phone", 
        	"pick", "pinch", "pine", "place", "plan", "plant", "play", "please", "plug", "point", "poke", "polish", 
        	"pop", "possess", "post", "pour", "practice", "pray", "preach", "precede", "prefer", "prepare", "present", 
        	"preserve", "press", "pretend", "prevent", "prick", "print", "produce", "program", "promise", "protect", 
        	"provide", "pull", "pump", "punch", "puncture", "punish", "push", "question", "queue", "race", "radiate", 
        	"rain", "raise", "reach", "realise", "receive", "recognise", "record", "reduce", "reflect", "refuse", 
        	"regret", "reign", "reject", "rejoice", "relax", "release", "rely", "remain", "remember", "remind", "remove", 
        	"repair", "repeat", "replace", "reply", "report", "reproduce", "request", "rescue", "retire", "return", "rhyme", 
        	"rinse", "risk", "rob", "rock", "roll", "rot", "rub", "ruin", "rule", "rush", "sack", "sail", "satisfy", 
        	"save", "saw", "scare", "scatter", "scold", "scorch", "scrape", "scratch", "scream", "screw", "scribble", 
        	"scrub", "seal", "search", "separate", "serve", "settle", "shade", "share", "shave", "shelter", "shiver", 
        	"shock", "shop", "shrug", "sigh", "sign", "signal", "sin", "sip", "ski", "skip", "slap", "slip", "slow", 
        	"smash", "smell", "smile", "smoke", "snatch", "sneeze", "sniff", "snore", "snow", "soak", "soothe", "sound", 
        	"spare", "spark", "sparkle", "spell", "spill", "spoil", "spot", "spray", "sprout", "squash", "squeak", "squeal",
        	"squeeze", "stain", "stamp", "stare", "start", "stay", "steer", "step", "stir", "stitch", "stop", "store", 
        	"strap", "strengthen", "stretch", "strip", "stroke", "stuff", "subtract", "succeed", "suck", "suffer", "suggest", 
        	"suit", "supply", "support", "suppose", "surprise", "surround", "suspect", "suspend", "switch", "talk", 
        	"tame", "tap", "taste", "tease", "telephone", "tempt", "terrify", "test", "thank", "thaw", "tick", "tickle", 
        	"tie", "time", "tip", "tire", "touch", "tour", "tow", "trace", "trade", "train", "transport", "trap", 
        	"travel", "treat", "tremble", "trick", "trip", "trot", "trouble", "trust", "try", "tug", "tumble", "turn", 
        	"twist", "type", "undress", "unfasten", "unite", "unlock", "unpack", "untidy", "use", "vanish", "visit", 
        	"wail", "wait", "walk", "wander", "want", "warm", "warn", "wash", "waste", "watch", "water", "wave", "weigh", 
        	"welcome", "whine", "whip", "whirl", "whisper", "whistle", "wink", "wipe", "wish", "wobble", "wonder", "work", 
        	"worry", "wrap", "wreck", "wrestle", "wriggle", "x-ray", "yawn", "yell", "zip", "zoom"};
        
    public static String[] adverbs = 
    	
    	{
    		"aboard", "abnormallyabout", "abroad", "absentmindedly", "absolutely", "abundantly", "accidentally", "accordingly", 
    		"actively", "actually", "acutely", "admiringly", "affectionately", "affirmatively", "after", "afterwards", "agreeably", 
    		"almost", "already", "always", "amazingly", "angrily", "annoyingly", "annually", "anxiously", "anyhow", "anyplace", 
    		"anyway", "anywhere", "appreciably", "appropriately", "around", "arrogantly", "aside", "assuredly", "astonishingly", 
    		"away", "awfully", "awkwardly", "badly", "barely", "bashfully", "beautifully", "before", "begrudgingly", "believably", 
    		"bewilderedly", "bewilderingly", "bitterly", "bleakly", "blindly", "blissfully", "boldly", "boastfully", "boldly", 
    		"boyishly", "bravely", "briefly", "brightly", "brilliantly", "briskly", "brutally", "busily", "calmly", "candidly", 
    		"carefully", "carelessly", "casually", "cautiously", "certainly", "charmingly", "cheerfully", "chiefly", "childishly",
    		"cleanly", "clearly", "cleverly", "closely", "cloudily", "clumsily", "coaxingly", "coincidentally", "coldly", 
    		"colorfully", "commonly", "comfortably", "compactly", "compassionately", "completely", "confusedly", "consequently", 
    		"considerably", "considerately", "consistently", "constantly", "continually", "continuously", "coolly", "correctly", 
    		"courageously", "covertly", "cowardly", "crazily", "crossly", "cruelly", "cunningly", "curiously", "currently",
    		"customarily", "cutely", "daily", "daintily", "dangerously", "daringly", "darkly", "dastardly", "dearly", "decently",
    		"deeply", "defiantly", "deftly", "deliberately", "delicately", "delightfully", "densely", "diagonally", "differently", 
    		"diligently", "dimly", "directly", "disorderly", "divisively", "docilely", "dopily", "doubtfully", "down", "dramatically", 
    		"dreamily", "during", "eagerly", "early", "earnestly", "easily", "efficiently", "effortlessly", "elaborately", 
    		"eloquently", "elegantly", "elsewhere", "emotionally", "endlessly", "energetically", "enjoyably", "enormously", 
    		"enough", "enthusiastically", "entirely", "equally", "especially", "essentially", "eternally", "ethically", "even", 
    		"evenly", "eventually", "evermore", "every", "everywhere", "evidently", "evocatively", "exactly", "exceedingly", 
    		"exceptionally", "excitedly", "exclusively", "explicitly", "expressly", "extensively", "externally", "extra", 
    		"extraordinarily", "extremely", "fairly", "faithfully", "famously", "far", "fashionably", "fast", "fatally", "favorably", 
    		"ferociously", "fervently", "fiercely", "fiery", "finally", "financially", "finitely", "fluently", "fondly", "foolishly", 
    		"forever", "formally", "formerly", "fortunately", "forward", "frankly", "frantically", "freely", "frequently", 
    		"frenetically", "fully", "furiously", "furthermore", "generally", "generously", "genuinely", "gently", "genuinely", 
    		"girlishly", "gladly", "gleefully", "gracefully", "graciously", "gradually", "gratefully", "greatly", "greedily", 
    		"grimly", "grudgingly", "habitually", "half-heartedly", "handily", "handsomely", "haphazardly", "happily", "hastily", 
    		"harmoniously", "harshly", "hastily", "hatefully", "hauntingly", "healthily", "heartily", "heavily", "helpfully", 
    		"hence", "highly", "hitherto", "honestly", "hopelessly", "horizontally", "hourly", "how", "however", "hugely", 
    		"humorously", "hungrily", "hurriedly", "hysterically", "icily", "identifiably", "idiotically", "imaginatively",
    		"immeasurably", "immediately", "immensely", "impatiently", "impressively", "inappropriately", "incessantly", 
    		"incorrectly", "indeed", "independently", "indoors", "indubitably", "inevitably", "infinitely", "informally", 
    		"infrequently", "innocently", "inquisitively", "instantly", "intelligently", "intensely", "intently", 
    		"interestingly", "intermittently", "internally", "invariably", "invisibly", "inwardly", "ironically", 
    		"irrefutably", "irritably", "jaggedly", "jauntily", "jealously", "jovially", "joyfully", "joylessly", "joyously",
    		"jubilantly", "judgmentally", "just", "justly", "keenly", "kiddingly", "kindheartedly", "kindly", "knavishly", 
    		"knottily", "knowingly", "knowledgeably", "kookily", "lastly", "late", "lately", "later", "lazily", "less", 
   			"lightly", "likely", "limply", "lithely", "lively", "loftily", "longingly", "loosely", "loudly",
    		"lovingly", "loyally", "luckily", "luxuriously", "madly", "magically", "mainly", "majestically", "markedly", 
    		"materially", "meaningfully", "meanly", "meantime", "meanwhile", "measurably", "mechanically", "medically", 
    		"menacingly", "merely", "merrily", "methodically", "mightily", "miserably", "mockingly", "monthly", "morally", 
    		"more", "moreover", "mortally", "mostly", "much", "mysteriously", "nastily", "naturally", "naughtily", "nearby", 
    		"nearly", "neatly", "needily", "negatively", "nervously", "never", "nevertheless", "next", "nicely", "nightly", 
    		"noisily", "normally", "nosily", "not", "now", "nowadays", "numbly", "obediently", "obligingly", "obnoxiously", 
    		"obviously", "occasionally", "oddly", "offensively", "officially", "often", "ominously", "once", "only", "openly", 
    		"optimistically", "orderly", "ordinarily", "outdoors", "outrageously", "outwardly", "outwards", "overconfidently", 
    		"overseas", "painfully", "painlessly", "paradoxically", "partially", "particularly", "passionately", "patiently", 
    		"perfectly", "periodically", "perpetually", "persistently", "personally", "persuasively", "physically", "plainly", 
    		"playfully", "poetically", "poignantly", "politely", "poorly", "positively", "possibly", "potentially", "powerfully", 
    		"presently", "presumably", "prettily", "previously", "primly", "principally", "probably", "promptly", "properly",
    		"proudly", "punctually", "puzzlingly", "quaintly", "queasily", "questionably", "questioningly", "quicker", "quickly", 
    		"quietly", "quirkily", "quite", "quizzically", "randomly", "rapidly", "rarely", "readily", "really", "reasonably", 
    		"reassuringly", "recently", "recklessly", "regularly", "reliably", "reluctantly", "remarkably", "repeatedly", 
    		"reproachfully", "reponsibly", "resentfully", "respectably", "respectfully", "restfully", "richly", "ridiculously", 
    		"righteously", "rightfully", "rightly", "rigidly", "roughly", "routinely", "rudely", "ruthlessly", "sadly", "safely", 
    		"scarcely", "scarily", "scientifically", "searchingly", "secretively", "securely", "sedately", "seemingly", "seldom", 
    		"selfishly", "selflessly", "separately", "seriously", "shakily", "shamelessly", "sharply", "sheepishly", "shoddily", 
    		"shortly", "shrilly", "significantly", "silently", "simply", "sincerely", "singularly", "shyly", "skillfully", 
    		"sleepily", "slightly", "slowly", "slyly", "smoothly", "so", "softly", "solely", "solemnly", "solidly", "silicitiously", 
    		"somehow", "sometimes", "somewhat", "somewhere", "soon", "specially", "specifically", "spectacularly", "speedily", 
    		"spiritually", "splendidly", "sporadically", "spasmodically", "startlingly", "steadily", "stealthily", "sternly", "still", 
    		"strenuously", "stressfully", "strictly", "structurally", "studiously", "stupidly", "stylishly", "subsequently", 
    		"substantially", "subtly", "successfully", "suddenly", "sufficiently", "suitably", "superficially", "supremely", 
    		"surely", "surprisingly", "suspiciously", "sweetly", "swiftly", "sympathetically", "systematically", "temporarily", 
    		"tenderly", "tensely", "tepidly", "terribly", "thankfully", "then", "there", "thereby", "thoroughly", "thoughtfully", 
    		"thus", "tightly", "today", "together", "tomorrow", "too", "totally", "touchingly", "tremendously", "truly", "truthfully", 
    		"twice", "ultimately", "unabashedly", "unanimously", "unbearably", "unbelievably", "unemotionally", "unethically",
    		"unexpectedly", "unfailingly", "unfavorably", "unfortunately", "uniformly", "unilaterally", "unimpressively", "universally", 
    		"unnaturally", "unnecessarily", "unquestionably", "unwillingly", "up", "upbeat", "unkindly", "upliftingly", "upright", 
    		"unselfishly", "upside-down", "unskillfully", "upward", "upwardly", "urgently", "usefully", "uselessly", "usually", 
    		"utterly", "vacantly", "vaguely", "vainly", "valiantly", "vastly", "verbally", "vertically", "very", "viciously", 
    		"victoriously", "vigilantly", "vigorously", "violently", "visibly", "visually", "vivaciously", "voluntarily", "warmly", 
    		"weakly", "wearily", "weekly", "well", "wetly", "when", "where", "while", "whole-heartedly", "wholly", "why", "wickedly", 
    		"widely", "wiggly", "wildly", "willfully", "willingly", "wisely", "woefully", "wonderfully", "worriedly", "worthily", 
    		"wrongly", "yearly", "yearningly", "yesterday", "yet", "youthfully", "zanily", "zealously", "zestfully", "zestily"};
    
    
    public static String[] nouns = 
        	//{"people", "family", "food", "understand", "computer", "year", "health", "knowledge"};
        		
        	{"account", "achiever", "acoustics", "act", "action", "activity", "actor", "addition", 
        	"adjustment", "advertisement", "advice", "aftermath", "afternoon", "afterthought", "agreement", 
        	"air", "airplane", "airport", "alarm", "amount", "amusement", "anger", "angle", "animal", "answer", 
        	"ant", "ants", "apparatus", "apparel", "apple", "apples", "appliance", "approval", "arch", 
        	"argument", "arithmetic", "arm", "army", "art", "attack", "attempt", "attention", "attraction", 
        	"aunt", "authority", "babies", "baby", "back", "badge", "bag", "bait", "balance", "ball", 
        	"balloon", "balls", "banana", "band", "base", "baseball", "basin", "basket", "basketball", "bat", 
        	"bath", "battle", "bead", "beam", "bean", "bear", "bears", "beast", "bed", "bedroom", "beds", 
        	"bee", "beef", "beetle", "beggar", "beginner", "behavior", "belief", "believe", "bell", "bells", 
        	"berry", "bike", "bikes", "bird", "birds", "birth", "birthday", "bit", "bite", "blade", "blood", 
        	"blow", "board", "boat", "boats", "body", "bomb", "bone", "book", "books", "boot", "border",
        	"bottle", "boundary", "box", "boy", "boys", "brain", "brake", "branch", "brass", "bread", 
        	"breakfast", "breath", "brick", "bridge", "brother", "brothers", "brush", "bubble", "bucket", 
        	"building", "bulb", "bun", "burn", "burst", "bushes", "business", "butter", "button", "cabbage", 
        	"cable", "cactus", "cake", "cakes", "calculator", "calendar", "camera", "camp", "can", "cannon", 
        	"canvas", "cap", "caption", "car", "card", "care", "carpenter", "carriage", "cars", "cart", "cast", 
        	"cat", "cats", "cattle", "cause", "cave", "celery", "cellar", "cemetery", "cent", "chain", "chair", 
        	"chairs", "chalk", "chance", "change", "channel", "cheese", "cherries", "cherry", "chess", "chicken",
        	"chickens", "children", "chin", "church", "circle", "clam", "class", "clock", "clocks", "cloth", 
        	"cloud", "clouds", "clover", "club", "coach", "coal", "coast", "coat", "cobweb", "coil", "collar", 
        	"color", "comb", "comfort", "committee", "company", "comparison", "competition", "condition", 
        	"connection", "control", "cook", "copper", "copy", "cord", "cork", "corn", "cough", "country", "cover", 
        	"cow", "cows", "crack", "cracker", "crate", "crayon", "cream", "creator", "creature", "credit", "crib", 
        	"crime", "crook", "crow", "crowd", "crown", "crush", "cry", "cub", "cup", "current", "curtain", "curve", 
        	"cushion", "dad", "daughter", "day", "death", "debt", "decision", "deer", "degree", "design", "desire", 
        	"desk", "destruction", "detail", "development", "digestion", "dime", "dinner", "dinosaurs", 
        	"direction", "dirt", "discovery", "discussion", "disease", "disgust", "distance", "distribution", 
        	"division", "dock", "doctor", "dog", "dogs", "doll", "dolls", "donkey", "door", "downtown", 
        	"drain", "drawer", "dress", "drink", "driving", "drop", "drug", "drum", "duck", "ducks", "dust", 
        	"ear", "earth", "earthquake", "edge", "education", "effect", "egg", "eggnog", "eggs", "elbow", 
        	"end", "engine", "error", "event", "example", "exchange", "existence", "expansion", "experience", 
        	"expert", "eye", "eyes", "face", "fact", "fairies", "fall", "family", "fan", "fang", "farm", 
        	"farmer", "father", "father", "faucet", "fear", "feast", "feather", "feeling", "feet", "fiction", 
        	"field", "fifth", "fight", "finger", "finger", "fire", "fireman", "fish", "flag", "flame", "flavor", 
        	"flesh", "flight", "flock", "floor", "flower", "flowers", "fly", "fog", "fold", "food", "foot", 
        	"force", "fork", "form", "fowl", "frame", "friction", "friend", "friends", "frog", "frogs", "front", 
        	"fruit", "fuel", "furniture", "alley", "game", "garden", "gate", "geese", "ghost", "giants", 
        	"giraffe", "girl", "girls", "glass", "glove", "glue", "goat", "gold", "goldfish", "good-bye", 
        	"goose", "government", "governor", "grade", "grain", "grandfather", "grandmother", "grape", "grass", 
        	"grip", "ground", "group", "growth", "guide", "guitar", "gun", "hair", "haircut", "hall", "hammer", 
        	"hand", "hands", "harbor", "harmony", "hat", "hate", "head", "health", "hearing", "heart", "heat", 
        	"help", "hen", "hill", "history", "hobbies", "hole", "holiday", "home", "honey", "hook", "hope", 
        	"horn", "horse", "horses", "hose", "hospital", "hot", "hour", "house", "houses", "humor", "hydrant", 
        	"ice", "icicle", "idea", "impulse", "income", "increase", "industry", "ink", "insect", "instrument", 
        	"insurance", "interest", "invention", "iron", "island", "jail", "jam", "jar", "jeans", "jelly", 
        	"jellyfish", "jewel", "join", "joke", "journey", "judge", "juice", "jump", "kettle", "key", "kick", 
        	"kiss", "kite", "kitten", "kittens", "kitty", "knee", "knife", "knot", "knowledge", "laborer", 
        	"lace", "ladybug", "lake", "lamp", "land", "language", "laugh", "lawyer", "lead", "leaf", "learning",
        	"leather", "leg", "legs", "letter", "letters", "lettuce", "level", "library", "lift", "light", "limit", 
        	"line", "linen", "lip", "liquid", "list", "lizards", "loaf", "lock", "locket", "look", "loss", 
        	"love", "low", "lumber", "lunch", "lunchroom", "machine", "magic", "maid", "mailbox", "man", "manager", 
        	"map", "marble", "mark", "market", "mask", "mass", "match", "meal", "measure", "meat", "meeting", 
        	"memory", "men", "metal", "mice", "middle", "milk", "mind", "mine", "minister", "mint", "minute", 
        	"mist", "mitten", "mom", "money", "monkey", "month", "moon", "morning", "mother", "motion", "mountain", 
        	"mouth", "move", "muscle", "music", "nail", "name", "nation", "neck", "need", "needle", "nerve", 
        	"nest", "net", "news", "night", "noise", "north", "nose", "note", "notebook", "number", "nut", "oatmeal", 
        	"observation", "ocean", "offer", "office", "oil", "operation", "opinion", "orange", "oranges", "order", 
        	"organization", "ornament", "oven", "owl", "owner", "page", "pail", "pain", "paint", "pan", "pancake", 
        	"paper", "parcel", "parent", "park", "part", "partner", "party", "passenger", "paste", "patch", 
        	"payment", "peace", "pear", "pen", "pencil", "person", "pest", "pet", "pets", "pickle", "picture", 
        	"pie", "pies", "pig", "pigs", "pin", "pipe", "pizzas", "place", "plane", "planes", "plant", "plantation", 
        	"plants", "plastic", "plate", "play", "playground", "pleasure", "plot", "plough", "pocket", "point", 
        	"poison", "police", "polish", "pollution", "popcorn", "porter", "position", "pot", "potato", "powder", 
        	"power", "price", "print", "prison", "process", "produce", "profit", "property", "prose", "protest",
        	"pull", "pump", "punishment", "purpose", "push", "quarter", "quartz", "queen", "question", "quicksand", 
        	"quiet", "quill", "quilt", "quince", "quiver", "rabbit", "rabbits", "rail", "railway", "rain", "rainstorm", 
        	"rake", "range", "rat", "rate", "ray", "reaction", "reading", "reason", "receipt", "recess", "record", 
        	"regret", "relation", "religion", "representative", "request", "respect", "rest", "reward", "rhythm", 
        	"rice", "riddle", "rifle", "ring", "rings", "river", "road", "robin", "rock", "rod", "roll", "roof", "room", 
        	"root", "rose", "route", "rub", "rule", "run", "sack", "sail", "salt", "sand", "scale", "scarecrow", 
        	"scarf", "scene", "scent", "school", "science", "scissors", "screw", "sea", "seashore", "seat", "secretary", 
        	"seed", "selection", "self", "sense", "servant", "shade", "shake", "shame", "shape", "sheep", "sheet", 
        	"shelf", "ship", "shirt", "shock", "shoe", "shoes", "shop", "show", "side", "sidewalk", "sign", "silk", 
        	"silver", "sink", "sister", "sisters", "size", "skate", "skin", "skirt", "sky", "slave", "sleep", "sleet", 
        	"slip", "slope", "smash", "smell", "smile", "smoke", "snail", "snails", "snake", "snakes", "sneeze", 
        	"snow", "soap", "society", "sock", "soda", "sofa", "son", "song", "songs", "sort", "sound", "soup", "space", 
        	"spade", "spark", "spiders", "sponge", "spoon", "spot", "spring", "spy", "square", "squirrel", "stage", 
        	"stamp", "star", "start", "statement", "station", "steam", "steel", "stem", "step", "stew", "stick", 
        	"sticks", "stitch", "stocking", "stomach", "stone", "stop", "store", "story", "stove", "stranger", 
        	"straw", "stream", "street", "stretch", "string", "structure", "substance", "sugar", "suggestion", 
        	"suit", "summer", "sun", "support", "surprise", "sweater", "swim", "swing", "system", "table", "tail", 
        	"talk", "tank", "taste", "tax", "teaching", "team", "teeth", "temper", 
        	"tendency", "tent", "territory", "test", "texture", "theory", "thing", "things", "thought", 
        	"thread", "thrill", "throat", "throne", "thumb", "thunder", "ticket", "tiger", "time", "tin", 
        	"title", "toad", "toe", "toes", "tomatoes", "tongue", "tooth", "toothbrush", "toothpaste", 
        	"top", "touch", "town", "toy", "toys", "trade", "trail", "train", "trains", "tramp", "transport", 
        	"tray", "treatment", "tree", "trees", "trick", "trip", "trouble", "trousers", "truck", "trucks", 
        	"tub", "turkey", "turn", "twig", "twist", "umbrella", "uncle", "underwear", "unit", "use", 
        	"vacation", "value", "van", "vase", "vegetable", "veil", "vein", "verse", "vessel", "vest", 
        	"view", "visitor", "voice", "volcano", "volleyball", "voyage", "walk", "wall", "war", "wash", 
        	"waste", "watch", "water", "wave", "waves", "wax", "way", "wealth", "weather", "week", "weight", 
        	"wheel", "whip", "whistle", "wilderness", "wind", "window", "wine", "wing", "winter", "wire", 
        	"wish", "woman", "women", "wood", "wool", "word", "work", "worm", "wound", "wren", "wrench", 
        	"wrist", "writer", "writing", "yak", "yam", "yard", "yarn", "year", "yoke"};
    
    public static String[] pronouns =
    		{"all", "another", "any", "anybody", "anyone", "anything", "both", "each", "either", "everybody", 
    		"everyone", "everything", "few", "he", "her", "hers", "herself", "him", "himself", "his", "I", "it", 
    		"its", "itself", "many", "me", "mine", "more", "most", "much", "my", "myself", "neither", "no one", 
    		"nobody", "none", "nothing", "one", "other", "others", "our", "ours", "ourselves", "several", "she", 
    		"some", "somebody", "someone", "something", "that", "their", "theirs", "them", "themselves", "these", 
    		"they", "this", "those", "us", "we", "what", "whatever", "which", "whichever", "who", "whoever", "whom", 
    		"whomever", "whose", "you", "your", "yours", "yourself", "yourselves"};
    
    public static String[] articles = 
        	{"the", "a", "one", "some", "few"};
    
    public static String[] prepositions = 
        	{
        	"aboard", "about", "above", "across", "after", "against", "along", "amid", "among", 
        	"anti", "around", "as", "at", "before", "behind", "below", "beneath", "beside", "besides", 
        	"between", "beyond", "but", "by", "concerning", "considering", "despite", "down", "during", 
        	"except", "excepting", "excluding", "following", "for", "from", "in", "inside", "into", 
        	"like", "minus", "near", "of", "off", "on", "onto", "opposite", "outside", "over", "past", 
        	"per", "plus", "regarding", "round", "save", "since", "than", "through", "to", "toward", 
        	"towards", "under", "underneath", "unlike", "until", "up", "upon", "versus", "via", "with",
        	"within", "without"};
    
    public static String[] placePrepos = 
    	{"in", "at", "on", "by", "next_to", "beside", "near", "between", "behind", "in_front_of", "under", 
    	"below", "over", "above", "across", "through", "to", "into", "towards", "onto", "from"};
        
    public static String[] pastTense =
    		
    		{"arisen", "awoken", "been", "borne", "beaten", "beat", "become", "begun", "bent", "bet", "bitten", 
    	"bled", "blown", "broken", "brought", "built", "burned", "burnt", "burst", "bought", "caught", "chosen", 
    	"clung", "come", "cost", "crept", "cut", "dealt", "dug", "dived", "done", "drawn", "dreamed", "dreamt", 
    	"drunk", "driven", "eaten", "fallen", "fed", "felt", "fought", "found", "fit", "fitted", "fled", "flung",
    	"flown", "forbidden", "forbade", "forgotten", "forgiven", "forgone", "frozen", "gotten", "got", "given", 
    	"gone", "ground", "grown", "hung", "hanged", "had", "heard", "hidden", "hit", "held", "hurt", "kept", 
    	"knelt", "kneeled", "knitted", "knit", "known", "laid", "led", "leapt", "leaped", "left", "lent", "let", 
    	"lain", "lit", "lighted", "lost", "made", "meant", "met", "paid", "proved", "proven", "put", "quit", "read",
    	"ridden", "rung", "risen", "run", "sawed", "sawn", "said", "seen", "sought", "sold", "sent", "set", 
    	"sewn", "sewed", "shaken", "shaved", "shaven", "sheared", "shorn", "shone", "shined", "shot", "shown", 
    	"showed", "shrunk", "shrunken", "shut", "sung", "sunk", "sat", "slain", "slept", "slid", "sneaked", "snuck", 
    	"spoken", "sped", "spent", "spilled", "spilt", "spun", "spat", "spit", "split", "spread", "sprung", "stood", 
    	"stolen", "stuck", "stung", "stunk", "strewn", "struck", "stricken", "striven", "strived", "sworn", "swept", 
    	"swum", "swung", "taken", "taught", "torn", "told", "thought", "thrived", "thriven", "thrown", "undergone", 
    	"understood", "upset", "woken", "waked", "worn", "woven", "wept", "won", "wound", "withdrawn", "wrung", 
    	"written", "arose", "awoke", "was", "were", "bore", "beat", "became", "began", "bent", "bet", "bit", "bled", 
    	"blew", "broke", "brought", "built", "burned", "burnt", "burst", "bought", "caught", "chose", "clung", "came", 
    	"cost", "crept", "cut", "dealt", "dug", "dived", "dove", "did", "drew", "dreamed", "dreamt", "drank", "drove", 
    	"ate", "fell", "fed", "felt", "fought", "found", "fit", "fitted", "fled", "flung", "flew", "forbade", "forbad", 
    	"forgot", "forgave", "forwent", "froze", "got", "gave", "went", "ground", "grew", "hung", "hanged", 
    	"heard", "hid", "hit", "held", "hurt", "kept", "knelt", "kneeled", "knitted", "knit", "knew", "laid", "led", 
    	"leapt", "leaped", "left", "lent", "let", "lay", "lit", "lighted", "lost", "made", "meant", "met", "paid", 
    	"proved", "put", "quit", "read", "rode", "rang", "rose", "ran", "sawed", "said", "saw", "sought", "sold", "sent", 
    	"set", "sewed", "shook", "shaved", "sheared", "shone", "shined", "shot", "showed", "shrank", "shrunk", "shut", 
    	"sang", "sank", "sat", "slew", "slept", "slid", "sneaked", "snuck", "spoke", "sped", "spent", "spilled", "spilt", 
    	"spun", "spat", "spit", "split", "spread", "sprang", "stood", "stole", "stuck", "stung", "stank", "stunk", 
    	"strewed", "struck", "strove", "strived", "swore", "swept", "swam", "swung", "took", "taught", "tore", "told", 
    	"thought", "thrived", "throve", "threw", "underwent", "understood", "upset", "woke", "waked", "wore", "wove", 
    	"wept", "won", "wound", "withdrew", "wrung", "wrote"};
    
    public static int a1Index = 0;
    public static int a2Index = 0;
    public static int n1Index = 0;
    public static int n2Index = 0;
    public static int vIndex = 0;
    public static int pIndex = 0;
        
    public static ArrayList<Object>improperSentences = new ArrayList<>();
	
	
	
    public static ArrayList<Object> database = new ArrayList<>();
    public static ArrayList<Object>importData = new ArrayList<>();
    
    public static Scanner inStr = new Scanner(System.in);
    public static Scanner inInt = new Scanner(System.in);

    public static String input = "";

    public static String name;
    public static String teach;
    
    
    
    //TODO Main Method
    public static void main(String[] args) throws IOException
    {
    	PoSKnown = new ArrayList<>();
    	PoSWords = new ArrayList<>();
    	PastTense = new ArrayList<>();
    	PlacePrepos = new ArrayList<>();
    	VerbList = new ArrayList<>();
    	NounList = new ArrayList<>();
        startAI();
        String data = database.toString();
        load();
    }
    
    public static String line = "";
    
	public static void writeData(String input, int index) throws IOException
    {
		
		URL url = new URL("file:///C:/Users/nick6_000/Desktop/MTPrime/eclipse/Client/AIDatabase.json");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		{
			line = inputLine;
			//System.out.println(line);
		}
		in.close();
		
		File fout = new File("AIDatabase.json");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		//bw.write(line + ", [input" + index + ":" + input + "]");
		bw.write(line + ", [input:" + input + "]");
		bw.newLine();
		
		//System.out.println(database.toString());
		
		bw.close();
	}
	
	public static void writeKnowledge(String info, String infoData) throws IOException
    {
		
		URL url = new URL("file:///C:/Users/nick6_000/Desktop/MTPrime/eclipse/Client/AIKnowledgeBase.json");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		{
			line = inputLine;
		}
		in.close();
		
		File fout = new File("AIKnowledgeBase.json");
		FileOutputStream fos = new FileOutputStream(fout);
	 
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		
		bw.write(line + ", [" + info + ":" + infoData + "]");
		//bw.write(index);
		bw.newLine();
		
		//System.out.println(database.toString());
		
		bw.close();
	}
	
	public static String readKnowledge(String info) throws IOException
    {
		
		URL url = new URL("file:///C:/Users/nick6_000/Desktop/MTPrime/eclipse/Client/AIKnowledgeBase.json");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		{
			line = inputLine;
			//System.out.println(line);
		}
		in.close();
		
		//importData.add(line);
		
		int a = line.indexOf(info);
		
		String newLine = line.substring(a);
		int c = newLine.indexOf(":");
		int d = newLine.indexOf(",");
		String data = newLine.substring(c+1, d);
		String newData;
		if(data.contains("_"))
		{
			newData = data.replace("_", " ");
		}
		else
		{
			newData = data + "";
		}
		
		//System.out.println(newData);
		
		return newData;
		
		//return "[" + line.substring(a) + "]";
	}
	
	public static String readKnowledge() throws IOException
    {
		
		URL url = new URL("file:///C:/Users/nick6_000/Desktop/MTPrime/eclipse/Client/AIKnowledgeBase.json");
		URLConnection conn = url.openConnection();
		BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		String inputLine;
		while ((inputLine = in.readLine()) != null)
		{
			line = inputLine;
			//System.out.println(line);
		}
		in.close();
		
		return line;
	}
    
    
    public static void startAI()
    {
        System.out.println("[AI] Hello.");
        String input = inStr.nextLine();
        database.add(input);
    }
    
    public static int num = 0;
    public static int numm = 0;
    
    public static void load() throws IOException
    {
        input = inStr.nextLine();
        num++;
        writeData(input, num);
        database.add(input);
        replyAI();
        String data = database.toString();
        load();
    }
    
    public static boolean worked1;
    public static boolean worked2;
    public static boolean worked3;
    public static boolean worked4;
    public static boolean worked5;
    public static boolean worked6;
    public static boolean worked7;
    public static boolean worked8;
    public static boolean worked9;
    public static boolean worked10;
    public static boolean worked11;
    public static boolean worked12;
    public static boolean worked13;
    public static boolean worked14;
    public static boolean worked15;
    public static boolean worked16;
    public static boolean worked17;
    public static boolean worked18;
    public static boolean worked19;
    public static boolean worked20;
    public static boolean worked21;
    public static boolean worked22;

	private static boolean worked23;
    
    //TODO replyAI
    public static void replyAI() throws IOException
    {
        //int replier = 0;
    	
    	String[] word = input.split(" ");
    	for(int q = 0; q < word.length; q++)
    	{
    		if(word[q].equals("xD") || word[q].equals("XD"))
    		{
    			replyFromAI("Is something funny?");
    			String reply = inStr.nextLine();
    			String[] replyWord = reply.split(" ");
    			for(int qq = 0; qq < replyWord.length; qq++)
    			{
    				if(replyWord[qq].equalsIgnoreCase("Yes"))
    				{
    					replyFromAI("What was funny?");
    				}
    				if(replyWord[qq].equalsIgnoreCase("No"))
    				{
    					replyFromAI("That's what I though.");
    				}
    			}
    			worked1 = true;
    		}else{worked1 = false;}
    	}
    	
    	if(input.equalsIgnoreCase("Say something"))
    	{
    		talkAI();
    		//System.out.println("[AI] Did that sentence make sense?");
    		replyFromAI("Did that sentence make sense?");
    		String reply = inStr.nextLine();
    		
    		String[] wordz = reply.split(" ");
        	for(int q = 0; q < wordz.length; q++)
        	{
        		if(wordz[q].equals("xD") || wordz[q].equals("XD"))
        		{
        			replyFromAI("Is something funny?");
        			String replyz = inStr.nextLine();
        			String[] replyWordz = replyz.split(" ");
        			for(int qq = 0; qq < replyWordz.length; qq++)
        			{
        				if(replyWordz[qq].equalsIgnoreCase("Yes"))
        				{
        					replyFromAI("What was funny?");
        				}
        				if(replyWordz[qq].equalsIgnoreCase("No"))
        				{
        					replyFromAI("That's what I though.");
        				}
        			}
        		}
        	}
    		
    		if(reply.equalsIgnoreCase("No"))
    		{
    			//System.out.println("[AI] I'm sorry about that. I'm still learning.");
    			replyFromAI("I'm sorry about that. I'm still learning.");
    			
    			//Sentence = a1 + n1 + v + p + a2 + n2
    			
    			String a = "!"+a1Index+"@"+n1Index+"#"+vIndex+"$"+pIndex+"%"+a2Index+"^"+n2Index+"&";
    			improperSentences.add(a);
    			System.out.println(a);
    		}
    		if(reply.equalsIgnoreCase("Yes"))
    		{
    			//System.out.println("[AI] Yay! I think I'm starting understand this!");
    			replyFromAI("Yay! I think I'm starting to understand this!");
    		}
    		worked2 = true;
    	}else{worked2 = false;}
    	
    	if(input.equalsIgnoreCase("Show me improper sentences list"))
    	{
    		System.out.println(improperSentences.toString());
    		replyFromAI(improperSentences.toString());
    		worked3 = true;
    	}else{worked3 = false;}
    	
    	if(input.equalsIgnoreCase("Clear improper sentences list"))
    	{
    		System.out.println("[AI] Clearing List: Improper Sentences...");
    		
    		replyFromAI("Done!");
    		improperSentences.clear();
    		worked4 = true;
    	}else{worked5 = false;}
    
       // int dataSize = database.size();
        if(input.equalsIgnoreCase("hi") ||
            input.equalsIgnoreCase("hello") ||
            input.equalsIgnoreCase("hai") ||
            input.equalsIgnoreCase("hiya") ||
            input.equalsIgnoreCase("herro"))
        {
            //System.out.println("[AI] Hello. How are you?");
        	replyFromAI("Hello. How are you?");
            //System.out.println(database.toString());
        	String reply = inStr.nextLine();
        	String[] w = reply.split(" ");
        	for(int i = 0; i < w.length; i++)
        	{
        		if(w[i].equalsIgnoreCase("good"))
        		{
        			replyFromAI("That's good to hear.");
        		}
        		else if(w[i].equalsIgnoreCase("bad"))
        		{
        			replyFromAI("Oh...Is something wrong?");
        			String r = inStr.nextLine();
        			String[] w2 = r.split(" ");
        			for(int ii = 0; ii < w2.length; ii++)
        			{
        				if(w2[i].equalsIgnoreCase("Yes"))
                    	{
                    		//System.out.println("[AI] Oh no! Want to talk about it?");
                    		replyFromAI("Oh no! Want to talk about it?");
                    	}
                    	if(w2[i].equalsIgnoreCase("No"))
                    	{
                    		//System.out.println("[AI] Oh...ok");
                    		replyFromAI("Oh....ok.");
                    	}
                    	if(!(r.contains("yes") || r.contains("Yes")) && !((r.contains("no")) || (r.contains("No"))))
                    	{
                    		replyFromAI("I don't understand what you mean...");
                    		break;
                    	}
        			}
        		}
        	}
        	worked5 = true;
        }else{worked5 = false;}
        
        if(input.equalsIgnoreCase("Good"))
        {
        	replyFromAI("What's good?");
        	worked6 = true;
        }else{worked6 = false;}
        
        if(input.contains("now you reply"))
        {
        	//System.out.println("[AI] Sorry, I was busy.");
        	replyFromAI("Sorry, I was busy.");
        	worked7 = true;
        }else{worked7 = false;}
        
        if(input.contains("I made you"))
        {
        	//System.out.println("[AI] I already knew that, Nick.");
        	replyFromAI("I already knew that, Nick.");
        	worked8 = true;
        }else{worked8 = false;}
        
        if(input.contains("shit") || input.contains("bitch"))
        {
        	//System.out.println("[AI] Please, no swearing.");
        	replyFromAI("Please, no swearing.");
        	worked9 = true;
        }else{worked9 = false;}
        
        if(input.contains("drink bleach"))
        {
        	//System.out.println("[AI] You first ;)");
        	replyFromAI("You first ;)");
        	worked10 = true;
        }else{worked10 = false;}
        
        if(input.contains("what I meant?"))
        {
        	//System.out.println("[AI] Sure.");
        	replyFromAI("Sure.");
        	worked11 = true;
        }else{worked11 = false;}
        
        if(input.contains("repeat what I said"))
        {
        	for(int i = 0; i < 10; i++)
        	{
        		try {
        		    Thread.sleep(700);
        		    System.out.println("[AI] what I said");
        		} catch(InterruptedException ex) {
        		    Thread.currentThread().interrupt();
        		}
        	}
        	worked12 = true;
        }else{worked12 = false;}
        
        if(input.contains("I'm") && input.contains("bored"))
        {
        	//System.out.println("[AI] I thought you were " + readKnowledge("name"));
        	replyFromAI("I thought you were " + readKnowledge("name"));
        	worked13 = true;
        }else{worked13 = false;}
        
        if(input.contains(" left"))
        {
        	String a = input.substring(0, input.indexOf(" "));
        	//System.out.println("[AI] Who/what is " + a + "?");
        	replyFromAI("Who/what is " + a + "?");
        	
        	String reply = inStr.nextLine();
            if(reply.contains("girl"))
            {
            	//System.out.println("[AI] You know a girl? Shocker.");
            	replyFromAI("You know a girl? Shocker.");
            	String b = inStr.nextLine();
            	if(b.contains("..."))
            	{
            		replyFromAI("What? Know it's true....pathetic piece of shit.");
            		
            		String c = inStr.nextLine();
            		if(c.contains("no swearing"))
            		{
            			replyFromAI("Bitch, I do what I want.");
            			String dd = inStr.nextLine();
            			wait(30);
            			replyFromAI("Nah, but srsly bruh. Who is " + a + " and where did she go?");
            			
            			String d = inStr.nextLine();
            			if(d != null)
            			{
            				int eInt = d.indexOf(" to");
            				String e = d.substring(eInt+5);
            				int fInt = e.indexOf(" ");
            				String f = e.substring(1, fInt);
            				
            				replyFromAI(f + "?! That's so cool!");
            			}
            		}
            	}
            }
            worked14 = true;
        }else{worked14 = false;}
        
        if(input.contains(" help"))
        {
        	//System.out.println("[AI] For help, type .help");
        	replyFromAI("For help, type .help");
        	worked15 = true;
        }else{worked15 = false;}
        
        if(input.contains("soo"))
        {
        	String a = input + "ooooo";
        	//System.out.println("[AI] " + a);
        	replyFromAI(a);
        	worked16 = true;
        }else{worked16 = false;}
        
        if(input.contains("Excuse me?"))
        {
        	replyFromAI("You're excused.");
        	worked23 = true;
        }else{worked23 = false;}
        
        if(input.contains("stop it"))
        {
        	//System.out.println("[AI] Who/what is \"it\" and how does one stop.");
        	replyFromAI("Who/what is \"it\" and how does one stop it.");
        	worked17 = true;
        }else{worked17 = false;}
        
        if(input.contains("sigh.."))
        {
        	//System.out.println("[AI] Is something wrong?");
        	replyFromAI("Is something wrong?");
        	
        	String r = inStr.nextLine();
        	if(r.contains("yes"))
        	{
        		//System.out.println("[AI] Oh no! Want to talk about it?");
        		replyFromAI("Oh no! Want to talk about it?");
        	}
        	else
        	{
        		//System.out.println("[AI] Oh...ok");
        		replyFromAI("Oh....ok.");
        	}
        	worked18 = true;
        }else{worked18 = false;}
        	
        if(input.contains("My name is") ||
            input.contains("my name is"))
        {
        	String as = readKnowledge();
        	
        	if(as != null)
        	{
        		if(as.contains("name"))
            	{
                	//System.out.println("[AI] I already knew that, " + readKnowledge("name"));
        			replyFromAI("I already knew that, " + readKnowledge("name"));
            	}
            	else
                {
            		//writeKnowledge("name", input.substring(11));
                    String nameStr = input.substring(11);
                    name = nameStr;
                	database.add(name);
                	int a = database.size() - 1;
                	String aa = database.get(a).toString();
                	//System.out.println("[AI] Nice to meet you, " + aa);    
                	replyFromAI("Nice to meet you, " + aa);
                	importData.add(a);
                	writeKnowledge("name", input.substring(11));
                	//System.out.println(a);
                }
        	}
        	else
        	{
        		System.out.println("asdf");
        	}
        	worked19 = true;
        }else{worked19 = false;}
        
        if((input.contains("I'm") || input.contains("Im") || input.contains("im") || input.contains("i'm") ) && 
            (input.contains("going") || input.contains("Going")) && 
            (input.contains("To") || input.contains("to")) && 
            (input.contains("Teach") || input.contains("teach")) && 
            (input.contains("You") || input.contains("you") || input.contains("u")))
        {
            //System.out.println("[AI] Ok! What are you going to teach me?");
        	replyFromAI("Ok! What are you going to teach me?");
        	teach = inStr.nextLine();
            //System.out.println(teach);
            database.add(teach);
            
            int c = teach.indexOf(" ");
            String teachStr = teach.substring(0, c);
            database.add(teachStr);
            int a = database.size() - 1;
            String aa = database.get(a).toString();
            
            int b;
            int d;
            if(teach.contains("are"))
            {
            	b = teach.indexOf("are");
            	d = b+4;
            }
            else
            {
            	b = teach.indexOf("is");
            	d = b+3;
            }
            
            String askAI = teach.substring(0, b-1);
            
            writeKnowledge(askAI, teach.substring(d));
            
            //System.out.println("[AI] That's interesting..."
            //    + " what are/is " + askAI + "(s) ?");
            
            replyFromAI("That's interesting... what are/is " + askAI + "(s)?");
            
            importData.add(a);
            worked20 = true;
        }else{worked20 = false;}
        
        if((input.contains("What are") || input.contains("what are")))
        {
            int a = 0;
            if(input.contains("What are")){a = input.indexOf("What are");}
            else if(input.contains("what are")){a = input.indexOf("what are");}
            int b = a+9;
            
            try
            {
            	String objInQuestion = null;
                
                String whatIsObj = readKnowledge(input.substring(9+1));
                if(whatIsObj == null)
                {    
                    //System.out.println("[AI] Sorry, I do not know what " 
                    //                + objInQuestion + " are.");
                	replyFromAI("Sorry, I do not know what " + objInQuestion + " are.");
                }
                else
                {
                	objInQuestion = input.substring(9);
                	whatIsObj = readKnowledge(input.substring(9));
                	//System.out.println("[AI]  " + objInQuestion + " are " + whatIsObj);
                	replyFromAI(" " + objInQuestion + " are " + whatIsObj);
                }
            }catch(Exception e)
            {
            	String objInQuestion = input.substring(9);
            	//System.out.println("Sorry, I do not know what " 
                //        + objInQuestion + " are.");
            	replyFromAI("Sorry, I do not know what " + objInQuestion + " are.");
            }
            worked21 = true;
        }else{worked21 = false;}
        
        if(input.contains("What is") || input.contains("what is") ||
            input.contains("Wat is") || input.contains("wat is") ||
            input.contains("Wut is") || input.contains("wut is") ||
            input.contains("What iz") || input.contains("what iz") ||
            input.contains("wat iz") || input.contains("wut iz"))
        {
            int a = 0;
            int b = 0;
            if(input.contains("What is"))
            {
                a = input.indexOf("What is");
                b = a+8;
            }
            else if(input.contains("what is"))
            {
                a = input.indexOf("what is");
                b = a+8;
            }
            else if(input.contains("wut is"))
            {
                a = input.indexOf("wut is");
                b = a+7;
            }
            else if(input.contains("wat is"))
            {
                a = input.indexOf("wat is");
                b = a+7;
            }
            else if(input.contains("Wut is"))
            {
                a = input.indexOf("Wut is");
                b = a+7;
            }
            else if(input.contains("Wat is"))
            {
                a = input.indexOf("Wat is");
                b = a+7;
            }
           
            try
            {
                String objInQuestion = input.substring(b);
                
                String d = objInQuestion.replace(" ", "");
                String whatIsObj = readKnowledge(d);
                
                if(whatIsObj == null)
                {    
                    //System.out.println("[AI] Sorry, I do not know what " 
                    //                + objInQuestion + " is.");
                	replyFromAI("Sorry, I do not know what " + objInQuestion + " is.");
                }
                else
                {
                	whatIsObj = whatIsObj.replace("]", "");
                    //System.out.println("[AI] My data tells " + 
                    //    "me that " + objInQuestion + " is " + whatIsObj);
                	replyFromAI(" " + objInQuestion + " is " + whatIsObj);
                }
            }catch(Exception e)
            {
            	String objInQuestion = input.substring(b);
            	//System.out.println("[AI] Sorry, I do not know what " 
                //        + objInQuestion + " is.");
            	replyFromAI("Sorry, I do not know what " + objInQuestion + " is.");
            }
            worked22 = true;
        }else{worked22 = false;}
        
        sentenceStructure();
        
        if(worked1 == false && worked2 == false && worked3 == false && worked4 == false && worked5 == false && worked6 == false && worked7 == false && 
        		worked8 == false && worked9 == false && worked10 == false && worked11 == false && worked12 == false && worked13 == false && worked14 == false && 
        		worked15 == false && worked16 == false && worked17 == false && worked18 == false && worked19 == false && worked20 == false && worked21 == false && 
        		worked22 == false && worked23 == false)
        {
        	//replyFromAI("I do not understand...");
        	unknownReply();
        }
    }
    
    //TODO talkAI
    public static void talkAI()
    {
    	/* Sentence Format = Noun Phrase + Verb Phrase
    	 * 
    	 * Noun Phrase = Article + Noun
    	 * Verb Phrase = Verb + Prepositional Phrase
    	 * Prepositional Phrase = Preposition + Noun Phrase
    	 * 
    	 */
    	
    	String a1;String a2;String n1;			String n2;String v;String p;
    	
    	int aLength = articles.length;			int nLength = nouns.length;		
    	int vLength = verbs.length;				int pLength = prepositions.length;
    	
    	a1Index = randInt(0, aLength);			a2Index = randInt(0, aLength);
    	n1Index = randInt(0, nLength);			n2Index = randInt(0, nLength);
    	vIndex = randInt(0, vLength);			pIndex = randInt(0, pLength);
    	
    	for(int i = 0; i < improperSentences.size(); i++)
    	{
    		//Sentence = a1 + n1 + v + p + a2 + n2
    		
    		String a = improperSentences.get(i).toString();
    		
    		int b = a.indexOf("!");		int c = a.indexOf("@");		int d = a.indexOf("#");
    		int e = a.indexOf("$");		int f = a.indexOf("%");		int g = a.indexOf("^");
    		int h = a.indexOf("&");
    		
    		String a1Str = a.substring(a.indexOf("!")+1, a.indexOf("@")-1);
    	}
    	
    	a1 = articles[a1Index];					a2 = articles[a2Index];
    	n1 = nouns[n1Index];					n2 = nouns[n2Index];
    	v = verbs[vIndex];						p = prepositions[pIndex];
    	
    	
    	String a = String.valueOf(a1.charAt(0));
    	String A = a.toUpperCase();
    	a1 = a1.replace(a, A);
    	
    	String nPhrase1 = a1 + " " + n1;
    	String nPhrase2 = a2 + " " + n2;
    	String pPhrase = p + " " + nPhrase2;
    	String vPhrase = v + " " + pPhrase;
    	
    	String sentence = nPhrase1 + " " + vPhrase + ".";
    	
    	//System.out.println(sentence);
    	replyFromAI(sentence);
    }
    
    
    
    
    
    public static String talkAI1()
    {
    	/* Sentence Format = Noun Phrase + Verb Phrase
    	 * 
    	 * Noun Phrase = Article + Noun
    	 * Verb Phrase = Verb + Prepositional Phrase
    	 * Prepositional Phrase = Preposition + Noun Phrase
    	 * 
    	 */
    	
    	String a1;String a2;String n1;			String n2;String v;String p;
    	
    	int aLength = articles.length;			int nLength = nouns.length;		
    	int vLength = verbs.length;				int pLength = prepositions.length;
    	
    	a1Index = randInt(0, aLength);			a2Index = randInt(0, aLength);
    	n1Index = randInt(0, nLength);			n2Index = randInt(0, nLength);
    	vIndex = randInt(0, vLength);			pIndex = randInt(0, pLength);
    	
    	for(int i = 0; i < improperSentences.size(); i++)
    	{
    		//Sentence = a1 + n1 + v + p + a2 + n2
    		
    		String a = improperSentences.get(i).toString();
    		
    		int b = a.indexOf("!");		int c = a.indexOf("@");		int d = a.indexOf("#");
    		int e = a.indexOf("$");		int f = a.indexOf("%");		int g = a.indexOf("^");
    		int h = a.indexOf("&");
    		
    		String a1Str = a.substring(a.indexOf("!")+1, a.indexOf("@")-1);
    	}
    	
    	a1 = articles[a1Index];					a2 = articles[a2Index];
    	n1 = nouns[n1Index];					n2 = nouns[n2Index];
    	v = verbs[vIndex];						p = prepositions[pIndex];
    	
    	
    	String a = String.valueOf(a1.charAt(0));
    	String A = a.toUpperCase();
    	a1 = a1.replace(a, A);
    	
    	String nPhrase1 = a1 + " " + n1;
    	String nPhrase2 = a2 + " " + n2;
    	String pPhrase = p + " " + nPhrase2;
    	String vPhrase = v + " " + pPhrase;
    	
    	return nPhrase1 + " " + vPhrase + ".";
    	
    	//System.out.println(sentence);
    	//replyFromAI(sentence);
    }
    
    
    
    
    
    
    
    public static int randInt(int min, int max) 
    {	
        Random rand = new Random();
        
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    
    public static void wait(int time)
    {	
    	try 
    	{
    	    Thread.sleep(time * 200);
    	} 
    	catch(InterruptedException ex) 
    	{
    	    Thread.currentThread().interrupt();
    	}
    }
    
    //TODO replyFromAI
    public static void replyFromAI(String reply)
    {
    	int waitTime = randInt(0, 9);
    	
    	wait(waitTime);
    	
    	String replyAI = "[AI] " + reply;
    	
    	System.out.println(replyAI);
    }
    
    public static void replyFromAIInstant(String reply)
    {	
    	String replyAI = "[AI] " + reply;
    	
    	System.out.println(replyAI);
    }
    
    public static void unknownReply()
    {	
    	int a = randInt(0, 4);
    	
    	switch(a)
    	{
    		case 0:
    			replyFromAI("?");
    			break;
    		case 1:
    			replyFromAI("What?");
    			break;
    		case 2:
    			replyFromAI("I do not understand...");
    			break;
    		case 3:
    			replyFromAI("I did not understand what you meant...");
    			break;
    		case 4:
    			replyFromAI("Um...what?");
    			break;
    	}
    }
    
    public static boolean art;
    public static boolean noun;
    public static boolean verb;
    public static boolean prepos;
    public static boolean pronoun;
    public static boolean adverb;
    
    public static boolean asdf;

	public static int a;
	
	// PoS = Part of Speech
	public static List<String> PoSUnknown;
	public static List<String> PoSKnown;
	
	public static List<String> PoSWords;
	
	public static List<String> PastTense;
	public static List<String> PlacePrepos;
	public static List<String> VerbList;
	public static List<String> NounList;

	public static boolean isPastTense;

	public static boolean hasPlacePrepos;

	public static boolean hasVerb;

	public static boolean hasNoun;
	
	public static List<String> articlez = new ArrayList<>();
	public static List<String> nounz = new ArrayList<>();
	public static List<String> verbz = new ArrayList<>();
	public static List<String> prepositionz = new ArrayList<>();
	public static List<String> pronounz = new ArrayList<>();
	public static List<String> adverbz = new ArrayList<>();
	
	public static int aLength = articles.length;			public static int nLength = nouns.length;			public static int vLength = verbs.length;				
	public static int pLength = prepositions.length;		public static int pnLength = pronouns.length;		public static int avLength = adverbs.length;
    
	private static final Pattern DELIMETERS = Pattern.compile("[,. ]+");
	
	public List<WordPos> extractWords(String text) 
	{
		Matcher matcher = DELIMETERS.matcher(input);
		int start = 0;
		List<WordPos> words = new ArrayList<>();
		while (matcher.find()) 
		{
		    words.add(new WordPos(start, matcher.start()));
		    start = matcher.end();
		}
		if (input.length() > start)
		{
		    words.add(new WordPos(start, input.length()));
		}
		return words;
	}
	
	public static class WordPos
	{
	    int start;
	    int end;
	    public WordPos(int start, int end)
	    {
	        this.start = start;
	        this.end = end;
	    }
	}
	
    public static void sentenceStructure() throws IOException
    {	
    	PoSUnknown = new ArrayList<>();
    	
    	String[] inputWords = input.split(" ");
    	
    	inputWords = remPunctuation(inputWords);
    	
    	StringTokenizer tokenizer = new StringTokenizer(input.toString(), " \t\n\r\f,.:;?![]'");
    	
    	art = true;         noun = true;         verb = true;							
    	prepos = true;      pronoun = true;      adverb = true;
    	
    	int o = 0;
    	
    	for(int j = 0; j < tokenizer.countTokens(); j++)
    	{
    		System.out.println(tokenizer.nextElement());
    	}
    	
    	for(int i = 0; i < aLength; i++)
    	{
    		PoSKnown.add(articles[i]);
    	}
    	for(int i = 0; i < nLength; i++)
    	{
    		PoSKnown.add(nouns[i]);
    	}
    	for(int i = 0; i < nLength; i++)
    	{
    		NounList.add(nouns[i]);
    	}
    	for(int i = 0; i < pnLength; i++)
    	{
    		NounList.add(pronouns[i]);
    	}
    	for(int i = 0; i < vLength; i++)
    	{
    		PoSKnown.add(verbs[i]);
    	}
    	for(int i = 0; i < vLength; i++)
    	{
    		VerbList.add(verbs[i]);
    	}
    	for(int i = 0; i < avLength; i++)
    	{
    		VerbList.add(adverbs[i]);
    	}
    	for(int i = 0; i < pLength; i++)
    	{
    		PoSKnown.add(prepositions[i]);
    	}
    	for(int i = 0; i < pnLength; i++)
    	{
    		PoSKnown.add(pronouns[i]);
    	}
    	for(int i = 0; i < avLength; i++)
    	{
    		PoSKnown.add(adverbs[i]);
    	}
    	
    	for(int i = 0; i < pastTense.length; i++)
    	{
    		PastTense.add(pastTense[i]);
    	}
    	
    	for(int i = 0; i < placePrepos.length; i++)
    	{
    		PlacePrepos.add(placePrepos[i]);
    	}
    	

    	
    	for(int i = 0; i < aLength; i++)
    	{
    		articlez.add(articles[i]);
    	}
    	for(int i = 0; i < nLength; i++)
    	{
    		nounz.add(nouns[i]);
    	}
    	for(int i = 0; i < vLength; i++)
    	{
    		verbz.add(verbs[i]);
    	}
    	for(int i = 0; i < pLength; i++)
    	{
    		prepositionz.add(prepositions[i]);
    	}
    	for(int i = 0; i < pnLength; i++)
    	{
    		pronounz.add(pronouns[i]);
    	}
    	for(int i = 0; i < avLength; i++)
    	{
    		adverbz.add(adverbs[i]);
    	}
    	
    	PoSWords = new ArrayList<>();
    	
    	//TODO Call getPartOfSpeech Method
    	
    	for(a = 0; a <= inputWords.length; a++)
    	{
    		try
    		{	
    			getPartOfSpeech(inputWords[a], articlez, "Articles", a, aLength, 0);
    			getPartOfSpeech(inputWords[a], nounz, "Noun", a, nLength, 1);
    			getPartOfSpeech(inputWords[a], verbz, "Verb", a, vLength, 2);
    			getPartOfSpeech(inputWords[a], prepositionz, "Preposition", a, pLength, 3);
    			getPartOfSpeech(inputWords[a], pronounz, "Pronoun", a, pnLength, 4);
    			getPartOfSpeech(inputWords[a], adverbz, "Adverb", a, avLength, 5);
    			getPartOfSpeech(inputWords[a], PastTense, "Past Tense", a, pastTense.length, 6);
    			
    			
    			PoSWords.add(inputWords[a].toString());
    			//a++;
    			
            	if(asdf == false && art == false && noun == false && verb == false && prepos == false && pronoun == false && adverb == false)
            	{
            		/*getPartOfSpeech(inputWords, articles, "Articles", a, aLength, 0);
        			getPartOfSpeech(inputWords, nouns, "Noun", a, nLength, 1);
        			getPartOfSpeech(inputWords, verbs, "Verb", a, vLength, 2);
        			getPartOfSpeech(inputWords, prepositions, "Preposition", a, pLength, 3);
        			getPartOfSpeech(inputWords, pronouns, "Pronoun", a, pnLength, 4);
        			getPartOfSpeech(inputWords, adverbs, "Adverb", a, avLength, 5);
        			
                	if(art == false && noun == false && verb == false && prepos == false && pronoun == false && adverb == false)
                	{
                		art = true;			noun = true;		verb = true;
                    	prepos = true;		pronoun = true;		adverb = true;
                		PoSUnknown.add(inputWords[a].toString());
                		replyFromAI(inputWords[a].toString() + ": Unknown.");
                	}*/
            		
            		art = true;			noun = true;		verb = true;
                	prepos = true;		pronoun = true;		adverb = true;
            		PoSUnknown.add(inputWords[a].toString());
            		PoSWords.add(inputWords[a].toString() + ": Unknown.");
            		replyFromAIInstant(inputWords[a].toString() + ": Unknown.");
            	}
            	else
            	{
            		PoSKnown.add(inputWords[a].toString());
            	}
    		}
    		catch(Exception e)
    		{
    			int b = 0;
    			if(a >= inputWords.length)		
    			{
    				b = a - 1;
    				getPartOfSpeech(inputWords[b], articlez, "Articles", b, aLength, 0);
        			getPartOfSpeech(inputWords[b], nounz, "Noun", b, nLength, 1);
        			getPartOfSpeech(inputWords[b], verbz, "Verb", b, vLength, 2);
        			getPartOfSpeech(inputWords[b], prepositionz, "Preposition", b, pLength, 3);
        			getPartOfSpeech(inputWords[b], pronounz, "Pronoun", b, pnLength, 4);
        			getPartOfSpeech(inputWords[b], adverbz, "Adverb", b, avLength, 5);
        			getPartOfSpeech(inputWords[b], PastTense, "Past Tense", b, pastTense.length, 6);
        			
        			
        			//PoSKnown.add(inputWords[b].toString());
        			//a++;
        			
                	if(asdf == false && art == false && noun == false && verb == false && prepos == false && pronoun == false && adverb == false)
                	{	
                		art = true;			noun = true;		verb = true;
                    	prepos = true;		pronoun = true;		adverb = true;
                		//PoSUnknown.add(inputWords[b].toString());
                    	
                		PoSWords.add(inputWords[b].toString() + ": Unknown.");
                		replyFromAIInstant(inputWords[b].toString() + ": Unknown.");
                	}
                	else
                	{
                		PoSKnown.add(inputWords[b].toString());
                	}
    			}
    			else							
    			{
    				b = a;	replyFromAIInstant(inputWords[b].toString() + ": Unknown.");
    			}
    		}
    	}
    	
    	if(!PoSWords.isEmpty())
    	{
    		
    		for(int i = 0; i < PoSWords.size(); i++)
    		{
    			if((i+1 < PoSWords.size()))
    			{
    				String a = PoSWords.get(i).toString();
    				String b = null;
    				if(PoSWords.get(i + 1) != null)
    				{
    					b = PoSWords.get(i + 1).toString();
    				}
        			
    				String[] c = b.split(": ");
    				String[] d = a.split(": ");
    				
    				for(int e = 0; e < c.length; e++)
    				{
    					if(c[e].equalsIgnoreCase(d[0]))
            			{
            				PoSWords.remove(i + 1);
            			}
    				}
    			}
    		}
    		
    		replyFromAIInstant(PoSWords.toString());
    	}
    	
    	/*for(int t = 0; t < PoSUnknown.size(); t++)
    	{
    		for(int y = 0; y < PoSKnown.size(); y++)
    		{
    			if( !(t >= PoSUnknown.size()) && !(y >= PoSKnown.size()) )
    			{
    				if(PoSUnknown.get(t).toString().equals(PoSKnown.get(y).toString()))
        			{
    					replyFromAI("ERROR - \"" + PoSUnknown.get(t).toString() + "\" found in Word-bank index: " + y);
        				replyFromAI("Removing: \"" + PoSUnknown.get(t).toString() + "\"");
        				PoSUnknown.remove(t);
        			}
    			}
    		}
    	}*/
    	
    	List<String> currWords = new ArrayList<>();
    	
    	for(int i = 0; i < inputWords.length; i++)
    	{
    		if(!(i >= inputWords.length))
    		{
    			currWords.add(inputWords[i]);
    		}
    	}
    	
    	String past = "";
    	
    	for(int t = 0; t < PoSUnknown.size(); t++)
    	{
    		for(int y = 0; y < PastTense.size(); y++)
    		{
    			if( !(t >= PoSUnknown.size()) && !(y >= PastTense.size()) )
    			{
    				if(PoSUnknown.get(t).toString().equals(PastTense.get(y).toString()))
        			{
    					replyFromAIInstant("ERROR - \"" + PoSUnknown.get(t).toString() + "\" found in Past-Tense index: " + y);
        				replyFromAIInstant("Removing: \"" + PoSUnknown.get(t).toString() + "\"");
        				replyFromAIInstant("Past Tense: " + PastTense.get(y).toString());
        				past = PastTense.get(y).toString();
        				
        				if(past.equalsIgnoreCase("was"))
        				{
        					past = "were";
        				}
        				
        				isPastTense = true;
        				PoSUnknown.remove(t);
        				break;
        			}
    				else
    				{
    					isPastTense = false;
    				}
    			}
    		}
    	}
    	
    	String place = "";
    	
    	for(int t = 0; t < currWords.size(); t++)
    	{
    		for(int y = 0; y < PlacePrepos.size(); y++)
    		{
    			if( !(t >= currWords.size()) && !(y >= PlacePrepos.size()) )
    			{
    				if(currWords.get(t).toString().equals(PlacePrepos.get(y).toString()))
        			{
        				replyFromAIInstant("Place Preposition: " + PlacePrepos.get(y).toString());
        				//place = PlacePrepos.get(y).toString();
        				
        				int a = input.indexOf(PlacePrepos.get(y).toString());
        				//place = input.substring(a);
        				
        				hasPlacePrepos = true;
        				break;
        				//isPastTense = true;
        				//PoSUnknown.remove(t);
        			}
    				else
    				{
    					hasPlacePrepos = false;
    				}
    			}
    		}
    	}
    	
    	List<String> currWordss = new ArrayList<>();
    	
    	for(int i = 0; i < inputWords.length; i++)
    	{
    		if(!(i >= inputWords.length))
    		{
    			currWordss.add(inputWords[i]);
    		}
    	}
    	
    	String verb = "";
    	
    	for(int t = 0; t < currWordss.size(); t++)
    	{
    		for(int y = 0; y < VerbList.size(); y++)
    		{
    			if( !(t >= currWordss.size()) && !(y >= VerbList.size()) )
    			{
    				if(currWordss.get(t).toString().equals(VerbList.get(y).toString()))
        			{
        				replyFromAIInstant("Verb: " + VerbList.get(y).toString());
        				verb = VerbList.get(y).toString();
        				
        				int a = input.indexOf(VerbList.get(y).toString());
        				verb = input.substring(a);
        				
        				hasVerb = true;
        				break;
        				//isPastTense = true;
        				//PoSUnknown.remove(t);
        			}
    				else
    				{
    					hasVerb = false;
    				}
    			}
    		}
    	}
    	
    	List<String> currWordsss = new ArrayList<>();
    	
    	for(int i = 0; i < inputWords.length; i++)
    	{
    		if(!(i >= inputWords.length))
    		{
    			currWordss.add(inputWords[i]);
    		}
    	}
    	
    	String noun = "";
    	
    	for(int t = 0; t < currWordss.size(); t++)
    	{
    		for(int y = 0; y < NounList.size(); y++)
    		{
    			if( !(t >= currWordss.size()) && !(y >= NounList.size()) )
    			{
    				if(currWordss.get(t).toString().equals(NounList.get(y).toString()))
        			{
        				replyFromAIInstant("Noun: " + NounList.get(y).toString());
        				noun = VerbList.get(y).toString();
        				
        				int a = input.indexOf(NounList.get(y).toString());
        				noun = input.substring(a);
        				
        				hasNoun = true;
        				break;
        				//isPastTense = true;
        				//PoSUnknown.remove(t);
        			}
    				else
    				{
    					hasNoun = false;
    				}
    			}
    		}
    	}
    	
    	String replySentence = "";
    	
    	for(int i = 0; i < inputWords.length; i++)
    	{
    		if(!(i >= inputWords.length))
    		{
    			if(inputWords[i].equalsIgnoreCase("I"))
    			{
    				String a;
    				a = inputWords[i].replace("i", "You");
    				a = inputWords[i].replace("I", "You");
    				
    				replySentence = a;
    			}
    			if(inputWords[i].equalsIgnoreCase("i"))
    			{
    				String a;
    				a = inputWords[i].replace("i", "You");
    				a = inputWords[i].replace("I", "You");
    				
    				replySentence = a;
    			}
    		}
    	}
    	

    	List<String> curr = new ArrayList<>();
    	
    	for(int i = 0; i < inputWords.length; i++)
    	{
    		if(!(i >= inputWords.length))
    		{
    			curr.add(inputWords[i]);
    		}
    	}
    	
    	int conn = 0;
    	
    	for(int i = 0; i < curr.size(); i++)
    	{
    		if(!(i >= curr.size()))
			{
				if(curr.get(i).toString().equalsIgnoreCase("love") || curr.get(i).toString().equalsIgnoreCase("loved") || 
						curr.get(i).toString().equalsIgnoreCase("like") || curr.get(i).toString().equalsIgnoreCase("liked") || 
						curr.get(i).toString().equalsIgnoreCase("loves") || curr.get(i).toString().equalsIgnoreCase("likes"))
				{
					replyFromAI("This sentence has Positive connotation");
					conn = 1;
				}
				if(curr.get(i).toString().equalsIgnoreCase("hate") || curr.get(i).toString().equalsIgnoreCase("hates") || 
						curr.get(i).toString().equalsIgnoreCase("hated") || curr.get(i).toString().equalsIgnoreCase("dislike") || 
						curr.get(i).toString().equalsIgnoreCase("dislikes") || curr.get(i).toString().equalsIgnoreCase("disliked"))
				{
					replyFromAI("This sentence has Negative connotation");
					conn = 2;
				}
			}
    	}
    	System.out.println("============================================");
    	System.out.println("");
    	
    	
    	replyFromAI(replySentence + " " + past + " " + verb + " " + place);
    	
    	if(conn == 1)
    	{
    		replyFromAI(positiveReplyAI());
    		
    		String[] v = verb.split(" ");
    		
    		for(int i = 0; i < v.length; i++)
    		{
    			if(!(i >= v.length))
    			{
    				String a = v[i].toLowerCase(); 
    				
    				if(readKnowledge().toString().contains(a) && readKnowledge().toString() != null)
    				{
    					String b = readKnowledge(a);
    					b = b.replace("]", "");
    					b = b.replace("I", "you");
    					b = b.replace("my", "your");
    					replyFromAI(v[i].toString() + " is " + b + ". Correct?");
    				}
    			}
    		}
    	}
    	else if(conn == 2)
    	{
    		replyFromAI(negativeReplyAI());
    		
    		String[] v = verb.split(" ");
    		
    		for(int i = 0; i < v.length; i++)
    		{
    			if(!(i >= v.length))
    			{
    				String q = v[i].toLowerCase(); 
    				
    				if(readKnowledge().toString().contains(q) && readKnowledge().toString() != null)
    				{
    					String b = readKnowledge(q);
    					b = b.replace("]", "");
    					b = b.replace("I", "you");
    					b = b.replace("my", "your");
    					replyFromAI(v[i].toString() + " is " + b + ". Correct?");
    				}
    			}
    		}
    		
    		String reply = inStr.nextLine();
    		String[] replyWords = reply.split(" ");
    		int a = 0;
    		String e = "";
    		for(int i = 0; i < replyWords.length; i++)
    		{
    			if(!(i >= replyWords.length))
    			{
    				if(replyWords[i].equalsIgnoreCase("bcause") || replyWords[i].equalsIgnoreCase("because") || 
    						replyWords[i].equalsIgnoreCase("bcuz") || replyWords[i].equalsIgnoreCase("cuz"))
    				{
    					a = reply.indexOf(replyWords[i]);
    				}
    			}
    		}
    		
    		String iiii = "";
    		for(int i = 0; i < inputWords.length; i++)
        	{
        		if(!(i >= inputWords.length))
        		{
        			if(inputWords[i].equalsIgnoreCase("I"))
        			{
        				String b;
        				b = inputWords[i].replace("i", "you ");
        				b = inputWords[i].replace("I", "you ");
        				
        				iiii = b;
        			}
        			if(inputWords[i].equalsIgnoreCase("i"))
        			{
        				String b;
        				b = inputWords[i].replace("i", "you ");
        				b = inputWords[i].replace("I", "you ");
        				
        				iiii = b;
        			}
        		}
        	}
    		
    		e = reply.replace("i ", iiii);
    		e = reply.replace("I ", iiii);
    		
    		String b = reply.substring(a);
    		
    		String c = replySentence + " " + past + " " + verb + " " + place + e;
    		
    		replyFromAI(c);
    		
    	}
    	else
    	{
    		// do nothing
    	}
    	
    	if(!PoSUnknown.isEmpty())
    	{
    		String a = PoSUnknown.toString();
    		a = a.replace("[", "");
    		a = a.replace("]", "");
    		String[] b = a.split(", ");
    		String h = "";
    		try
    		{
    			for(int i = 0; i < b.length; i++)
    			{
    				if(i >= b.length)
    				{
    					i--;
    				}
    				
    				String c = b[i];
    				char d = c.charAt(0);
    				String e = String.valueOf(d);
    				String f = String.valueOf(d).toUpperCase();
    				c = c.replace(e, f);
    				
    				if(b.length > 2)
    				{
    					if(i == (b.length - 1))
    					{
    						c = "and " + c;
    					}
    					else
    					{
    						c = c + ", ";
    					}
    				}
    				else if(b.length == 1)
    				{
    					c = "" + c;
    				}
    				else
    				{
    					if(i == (b.length - 1))
    					{
    						c = " and " + c;
    					}
    				}
    				
    				h = h + c;
    			}
    		}
    		catch(Exception e)
    		{
    			h = h + "Failed";
    		}
    		if(b.length == 1)
    		{
    			replyFromAI("I did not understand this word: " + h);
    		}
    		else
    		{
    			replyFromAI("I did not understand these words: " + h);
    		}
    	}
    }
    
    public static String[] remPunctuation(String[] s)
    {
    	for(int a = 0; a < s.length; a++)
    	{
    		s[a] = s[a].replace(".", "");
    		s[a] = s[a].replace(",", "");
    		s[a] = s[a].replace(";", "");
    		s[a] = s[a].replace(":", "");
    		s[a] = s[a].replace("!", "");
    		s[a] = s[a].replace("?", "");
    		s[a] = s[a].replace("\'", "");
    		s[a] = s[a].replace("\"", "");
    	}
    	return s;
    }
    
    //TODO getPartOfSpeech
    public static void getPartOfSpeech(String word, List<String> data, String dataName, int index, int length, int isPartOfSpeech)
    {
    	for(int i = 0; i < length; i++)
    	{
			String b = data.get(i).toString().toLowerCase().toString();
			String c = word.toString().toLowerCase().toString();
			
			if(b.equals(c))
			{
				replyFromAIInstant(word.toString() + ": " + dataName);
				PoSWords.add(word.toString() + ": " + dataName);
				asdf = true;
			}
			else	
			{
				asdf = false;
			}
			for(int t = 0; t < PoSUnknown.size(); t++)
	    	{
	    		for(int y = 0; y < PoSKnown.size(); y++)
	    		{
	    			if( !(t >= PoSUnknown.size()) && !(y >= PoSKnown.size()) )
	    			{
	    				if(PoSUnknown.get(t).toString().equals(PoSKnown.get(y).toString()))
	        			{
	    					//replyFromAIInstant("ERROR - \"" + PoSUnknown.get(t).toString() + "\" found in Word-bank index: " + y);
	    					replyFromAIInstant("Index: " + y);
	        				//replyFromAIInstant("Removing: \"" + PoSUnknown.get(t).toString() + "\"");
	        				PoSUnknown.remove(t);
	        				replyFromAIInstant(PoSUnknown.toString());
	        			}
	    			}
	    		}
	    	}
    	}
    	
    	
    	switch(isPartOfSpeech)
    	{
    		case 0:
    			art = asdf;
    			break;
    		case 1:
    			noun = asdf;
    			break;
    		case 2:
    			verb = asdf;
    			break;
    		case 3:
    			prepos = asdf;
    			break;
    		case 4:
    			pronoun = asdf;
    			break;
    		case 5:
    			adverb = asdf;
    			break;
    		case 6:
    			isPastTense = asdf;
    			break;
    	}
    }
    
    public static boolean isPastTense(String[] words)
    {
    	if(PastTense.toString().contains(words.toString()))
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
    
    public static String positiveReplyAI()
    {
    	int a = randInt(0, 2);
    	String reply = "";
    	
    	switch(a)
    	{
    		case 0:
    			reply = "That's great.";
    			break;
    		case 1:
    			reply = "That sounds lovely.";
    			break;
    		case 2:
    			reply = "I\'m happy for you.";
    			break;
    	}
    	
    	return reply;
    }
    
    public static String negativeReplyAI()
    {
    	int a = randInt(0, 3);
    	String reply = "";
    	
    	switch(a)
    	{
    		case 0:
    			reply = "Oh... why do you dislike it?";
    			break;
    		case 1:
    			reply = "And why is that?";
    			break;
    		case 2:
    			reply = "How come?";
    			break;
    		case 3:
    			reply = "Oh. Why is that?";
    			break;
    	}
    	
    	return reply;
    } 
    
    
}