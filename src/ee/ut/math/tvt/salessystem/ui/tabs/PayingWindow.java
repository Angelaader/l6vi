package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

public class PayingWindow {
	private static final Logger log = Logger.getLogger(PayingWindow.class);
	double totalSum;

	public Component draw() throws ParseException {
		final JFrame item = new JFrame();
		item.setAlwaysOnTop(true);
		item.setSize(new Dimension(300, 250));
		item.setResizable(false);
		item.setTitle("Order conformation");
		JPanel popUp = new JPanel();
		popUp.setLayout(new GridBagLayout());
		popUp.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		popUp.setSize(300, 250);
		GridBagConstraints c = new GridBagConstraints();
		final Fields moneyBack = new Fields();
		moneyBack.setEditable(false);
		JLabel sumWindow = new JLabel("The cost of your order is: "
				+ String.format(Locale.ENGLISH, "%.2f", totalSum));
		final Fields payMoney = new Fields();
		item.add(popUp);
		payMoney.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
				data();
			}

			public void insertUpdate(DocumentEvent arg0) {
				data();
			}

			public void removeUpdate(DocumentEvent arg0) {
				data();
			}

			private void data() {
				try {
					if (!payMoney.getText().isEmpty()) {
						double changeBack = Double.parseDouble(payMoney
								.getText()) - totalSum;
						changeBack = Math.round(changeBack * 100.0) / 100.0;
						moneyBack.setText(String.format(Locale.ENGLISH, "%.2f",
								changeBack));
					}
				} catch (NumberFormatException e) {
				}
			}
		});
		sumWindow.setSize(300, 75);
		c.gridx = 0;
		c.gridy = 0;
		popUp.add(sumWindow, c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 1;
		popUp.add(payMoney, c);
		c.gridx = 0;
		c.gridy = 2;
		JLabel dp = new JLabel("Payment amount");
		popUp.add(dp, c);
		c.gridx = 1;
		c.gridy = 2;
		c.fill = GridBagConstraints.HORIZONTAL;
		popUp.add(moneyBack, c);
		c.gridx = 0;
		c.gridy = 3;
		JButton confirm = new JButton("Confirm buy");
		confirm.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					if (Double.parseDouble(moneyBack.getText()) >= 0.0) {
						item.dispose();
						log.info("Sale completed");
					}
				} catch (NumberFormatException e) {
				}
			}
		});
		popUp.add(confirm, c);
		c.gridx = 1;
		c.gridy = 3;
		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				item.dispose();
				log.info("Sale canceled");
			}
		});
		popUp.add(cancel, c);
		return item;
	}

	public void setCost(double totalSum) {
		this.totalSum = totalSum;
	}
}