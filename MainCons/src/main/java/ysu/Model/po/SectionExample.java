package ysu.Model.po;

import java.util.ArrayList;
import java.util.List;

public class SectionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SectionExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("Id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("Id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("Id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("Id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("Id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("Id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("Id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("Id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("Id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("Id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNull() {
            addCriterion("Section_name is null");
            return (Criteria) this;
        }

        public Criteria andSectionNameIsNotNull() {
            addCriterion("Section_name is not null");
            return (Criteria) this;
        }

        public Criteria andSectionNameEqualTo(String value) {
            addCriterion("Section_name =", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotEqualTo(String value) {
            addCriterion("Section_name <>", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThan(String value) {
            addCriterion("Section_name >", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameGreaterThanOrEqualTo(String value) {
            addCriterion("Section_name >=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThan(String value) {
            addCriterion("Section_name <", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLessThanOrEqualTo(String value) {
            addCriterion("Section_name <=", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameLike(String value) {
            addCriterion("Section_name like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotLike(String value) {
            addCriterion("Section_name not like", value, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameIn(List<String> values) {
            addCriterion("Section_name in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotIn(List<String> values) {
            addCriterion("Section_name not in", values, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameBetween(String value1, String value2) {
            addCriterion("Section_name between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andSectionNameNotBetween(String value1, String value2) {
            addCriterion("Section_name not between", value1, value2, "sectionName");
            return (Criteria) this;
        }

        public Criteria andPostNumberIsNull() {
            addCriterion("Post_number is null");
            return (Criteria) this;
        }

        public Criteria andPostNumberIsNotNull() {
            addCriterion("Post_number is not null");
            return (Criteria) this;
        }

        public Criteria andPostNumberEqualTo(Integer value) {
            addCriterion("Post_number =", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberNotEqualTo(Integer value) {
            addCriterion("Post_number <>", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberGreaterThan(Integer value) {
            addCriterion("Post_number >", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberGreaterThanOrEqualTo(Integer value) {
            addCriterion("Post_number >=", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberLessThan(Integer value) {
            addCriterion("Post_number <", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberLessThanOrEqualTo(Integer value) {
            addCriterion("Post_number <=", value, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberIn(List<Integer> values) {
            addCriterion("Post_number in", values, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberNotIn(List<Integer> values) {
            addCriterion("Post_number not in", values, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberBetween(Integer value1, Integer value2) {
            addCriterion("Post_number between", value1, value2, "postNumber");
            return (Criteria) this;
        }

        public Criteria andPostNumberNotBetween(Integer value1, Integer value2) {
            addCriterion("Post_number not between", value1, value2, "postNumber");
            return (Criteria) this;
        }

        public Criteria andModeratorIdIsNull() {
            addCriterion("Moderator_id is null");
            return (Criteria) this;
        }

        public Criteria andModeratorIdIsNotNull() {
            addCriterion("Moderator_id is not null");
            return (Criteria) this;
        }

        public Criteria andModeratorIdEqualTo(Integer value) {
            addCriterion("Moderator_id =", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdNotEqualTo(Integer value) {
            addCriterion("Moderator_id <>", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdGreaterThan(Integer value) {
            addCriterion("Moderator_id >", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("Moderator_id >=", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdLessThan(Integer value) {
            addCriterion("Moderator_id <", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdLessThanOrEqualTo(Integer value) {
            addCriterion("Moderator_id <=", value, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdIn(List<Integer> values) {
            addCriterion("Moderator_id in", values, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdNotIn(List<Integer> values) {
            addCriterion("Moderator_id not in", values, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdBetween(Integer value1, Integer value2) {
            addCriterion("Moderator_id between", value1, value2, "moderatorId");
            return (Criteria) this;
        }

        public Criteria andModeratorIdNotBetween(Integer value1, Integer value2) {
            addCriterion("Moderator_id not between", value1, value2, "moderatorId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}