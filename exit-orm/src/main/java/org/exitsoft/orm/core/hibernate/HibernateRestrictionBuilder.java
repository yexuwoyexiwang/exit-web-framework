package org.exitsoft.orm.core.hibernate;

import org.exitsoft.orm.core.PropertyFilter;
import org.exitsoft.orm.core.PropertyFilterBuilder;
import org.exitsoft.orm.core.hibernate.restriction.support.EqRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.GeRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.GtRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.InRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.LLikeRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.LeRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.LikeRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.LtRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.NeRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.NinRestriction;
import org.exitsoft.orm.core.hibernate.restriction.support.RLikeRestriction;
import org.hibernate.criterion.Criterion;

/**
 * Hibernate约束捆绑者，帮助HibernateDao对buildCriterion方法创建相对的Criterion对象给Hibernate查询
 * 
 * @author vincent
 *
 */
public class HibernateRestrictionBuilder extends PropertyFilterBuilder<PropertyCriterionBuilder,Criterion>{
	
	public HibernateRestrictionBuilder() {
		
		PropertyCriterionBuilder eqRestriction = new EqRestriction();
		PropertyCriterionBuilder neRestriction = new NeRestriction();
		PropertyCriterionBuilder geRestriction = new GeRestriction();
		PropertyCriterionBuilder gtRestriction = new GtRestriction();
		PropertyCriterionBuilder inRestriction = new InRestriction();
		PropertyCriterionBuilder lLikeRestriction = new LLikeRestriction();
		PropertyCriterionBuilder leRestriction = new LeRestriction();
		PropertyCriterionBuilder likeRestriction = new LikeRestriction();
		PropertyCriterionBuilder ltRestriction = new LtRestriction();
		PropertyCriterionBuilder notInRestriction = new NinRestriction();
		PropertyCriterionBuilder rLikeRestriction = new RLikeRestriction();
		
		getRestrictionsMap().put(eqRestriction.getRestrictionName(), eqRestriction);
		getRestrictionsMap().put(neRestriction.getRestrictionName(), neRestriction);
		getRestrictionsMap().put(geRestriction.getRestrictionName(), geRestriction);
		getRestrictionsMap().put(inRestriction.getRestrictionName(), inRestriction);
		getRestrictionsMap().put(gtRestriction.getRestrictionName(), gtRestriction);
		getRestrictionsMap().put(lLikeRestriction.getRestrictionName(), lLikeRestriction);
		getRestrictionsMap().put(leRestriction.getRestrictionName(), leRestriction);
		getRestrictionsMap().put(likeRestriction.getRestrictionName(), likeRestriction);
		getRestrictionsMap().put(ltRestriction.getRestrictionName(), ltRestriction);
		getRestrictionsMap().put(rLikeRestriction.getRestrictionName(), rLikeRestriction);
		getRestrictionsMap().put(notInRestriction.getRestrictionName(), notInRestriction);
	}
	
	@Override
	public Criterion getRestriction(PropertyFilter filter) {
		PropertyCriterionBuilder criterionBuilder = getRestrictionsMap().get(filter.getRestrictionName());
		return criterionBuilder.build(filter);
	}

	@Override
	public Criterion getRestriction(String propertyName, Object value,String restrictionName) {
		PropertyCriterionBuilder restriction = getRestrictionsMap().get(restrictionName);
		return restriction.build(propertyName, value);
	}
	
	
	
}