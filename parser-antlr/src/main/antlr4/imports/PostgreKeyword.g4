lexer grammar PostgreKeyword;

import Symbol;
   
GLOBAL: G L O B A L;
LOCAL: L O C A L;
TEMP: T E M P;
UNLOGGED: U N L O G G E D;
COLLATE: C O L L A T E;
INHERITS: I N H E R I T S;

//WITH: W I T H;
OIDS: O I D S;
//WITHOUT: W I T H O U T;
//ON: O N;
//COMMIT: C O M M I T;
PRESERVE: P R E S E R V E;
ROWS: R O W S;
//DELETE: D E L E T E;
//DROP: D R O P;
//TABLESPACE: T A B L E S P A C E;
//OF: O F;
OPTIONS: O P T I O N S;
//FOR: F O R;
//VALUES: V A L U E S;
//CONSTRAINT: C O N S T R A I N T;
//NULL: N U L L;
//CHECK: C H E C K;
NO: N O;
INHERIT: I N H E R I T;
DEFAULT: D E F A U L T;
GENERATED: G E N E R A T E D;
ALWAYS: A L W A Y S;
//AS: A S;
IDENTITY: I D E N T I T Y;
//UNIQUE: U N I Q U E;
//PRIMARY: P R I M A R Y;
//KEY: K E Y;
//REFERENCES: R E F E R E N C E S;
//MATCH: M A T C H;
//FULL: F U L L;
PARTIAL: P A R T I A L;
SIMPLE: S I M P L E;
//UPDATE: U P D A T E;

DEFERRABLE: D E F E R R A B L E;
INITIALLY: I N I T I A L L Y;
DEFERRED: D E F E R R E D;
IMMEDIATE: I M M E D I A T E;
EXCLUDE: E X C L U D E;
//USING: U S I N G;
//WHERE: W H E R E;
//FOREIGN: F O R E I G N;
INCLUDING: I N C L U D I N G;
EXCLUDING: E X C L U D I N G;
COMMENTS: C O M M E N T S;
CONSTRAINTS: C O N S T R A I N T S;
DEFAULTS: D E F A U L T S;
INDEXES: I N D E X E S;
STATISTICS: S T A T I S T I C S;
STORAGE: S T O R A G E;
//ALL: A L L;
//IN: I N;
//TRUE: T R U E;
//FALSE: F A L S E;
//FROM: F R O M;
MINVALUE: M I N V A L U E;
MAXVALUE: M A X V A L U E;
//TO: T O;
//INDEX: I N D E X;
//ASC: A S C;
//DESC: D E S C;
//NULLS: N U L L S;
//FIRST: F I R S T;
//LAST: L A S T;
REFERENCES: R E F E R E N C E S;
INCREMENT: I N C R E M E N T;
START: S T A R T;
CACHE: C A C H E;
CYCLE: C Y C L E;
FULL: F U L L;
ACTION: A C T I O N;
RESTRICT: R E S T R I C T;
CASCADE: C A S C A D E;
NULLS: N U L L S;
MATCH: M A T C H;
FIRST: F I R S T;
LAST: L A S T;


INT8: I N T '8';
BIGSERIAL: B I G S E R I A L;
SERIAL8: S E R I A L '8';
BIT: B I T;
VARYING: V A R Y I N G;
VARBIT: V A R B I T;
BOOLEAN: B O O L E A N;
BOOL: B O O L;
BOX: B O X;
BYTEA: B Y T E A;
CIDR: C I D R;
CHARACTER: C H A R A C T E R;
CIRCLE: C I R C L E;
SERIAL: S E R I A L;
PRECISION: P R E C I S I O N;
FLOAT8: F L O A T '8';
INET: I N E T;
INT4: I N T '4';
JSONB: J S O N B;
LINE: L I N E;
LSEG: L S E G;
MACADDR: M A C A D D R;
MACADDR8: M A C A D D R '8';
MONEY: M O N E Y;
PATH: P A T H;
PG_LSN: P G UL_ L S N;
POINT: P O I N T;
POLYGON: P O L Y G O N;
REAL: R E A L;
FLOAT4: F L O A T '4';
SMALLSERIAL: S M A L L S E R I A L;
SERIAL4: S E R I A L'4';
ZONE: Z O N E;
INT2: I N T '2';
TSQUERY: T S Q U E R Y;
TSVECTOR:T S V E C T O R;
TXID_SNAPSHOT: T X I D UL_ S N A P S H O T;
UUID: U U I D;
INTERVAL: I N T E R V A L;
XML: X M L;
