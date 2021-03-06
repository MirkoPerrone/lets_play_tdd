package com.jamesshore.finances.ui;

import javax.swing.*;
import net.miginfocom.swing.*;
import com.jamesshore.finances.persistence.*;
import com.jamesshore.finances.ui.DollarsTextField.ChangeListener;

public class ConfigurationPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private UserConfiguration userConfiguration;

	public ConfigurationPanel(UserConfiguration userConfiguration) {
		this.userConfiguration = userConfiguration;
		addComponents();
	}

	private void addComponents() {
		this.setLayout(new MigLayout("fillx, wrap 2", "[right]rel[grow]"));
		addField("Starting Balance:", startingBalanceField());
		addField("Cost Basis:", costBasisField());
		addField("Yearly Spending:", yearlySpendingField());
	}

	private void addField(String name, DollarsTextField field) {
		this.add(new JLabel(name));
		this.add(field, "growx");
	}

	public DollarsTextField startingBalanceField() {
		final DollarsTextField field = new DollarsTextField(userConfiguration.getStartingBalance());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				userConfiguration.setStartingBalance(field.getDollars());
			}
		});
		return field;
	}

	private DollarsTextField costBasisField() {
		final DollarsTextField field = new DollarsTextField(userConfiguration.getStartingCostBasis());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				userConfiguration.setStartingCostBasis(field.getDollars());
			}
		});
		return field;
	}

	private DollarsTextField yearlySpendingField() {
		final DollarsTextField field = new DollarsTextField(userConfiguration.getYearlySpending());
		field.addTextChangeListener(new ChangeListener() {
			public void textChanged() {
				userConfiguration.setYearlySpending(field.getDollars());
			}
		});
		return field;
	}
}
