package ee.ut.math.tvt.salessystem.ui.tabs;

import javax.swing.JTextField;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
 
public class Fields extends JTextField {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Fields() {
        super();
    }

    public Fields( int cols ) {
        super( cols );
    }

    protected Document createDefaultModel() {
        return new UpperCaseDocument();
    }

    static class UpperCaseDocument extends PlainDocument {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

        public void insertString( int off, String string, AttributeSet abr ) throws BadLocationException {
            if ( string == null ) {
                return;
            }
            boolean ok = true;
            char[] chars = string.toCharArray();
            for ( int i = 0; i < chars.length; i++ ) {
                try {
                	if (!( String.valueOf( chars[i] ).equals("."))){
                		Integer.parseInt( String.valueOf( chars[i] ) );
                	}
                } catch ( NumberFormatException exc ) {
                    ok = false;
                    break;
                }
            }
            if ( ok )
                super.insertString( off, new String( chars ), abr );
        }
    }
}