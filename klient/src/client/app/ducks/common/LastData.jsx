import React, { Component } from 'react';

class LastData extends Component {
  componentDidMount() {
    if (this.props.idToShow && this.props.idToShow !== this.props.idShowing && !this.props.loading) {
      this.props.fetch(this.props.idToShow);
    }
  }

  componentWillReceiveProps(nextProps) {
    if (nextProps.idToShow && nextProps.idShowing !== nextProps.idToShow && !nextProps.loading) {
      this.props.fetch(nextProps.idToShow);
    }
  }
  render() {
    if (this.props.idToShow !== this.props.idShowing) {
      return null;
    }

    if (this.props.loading) {
      return null;
    }
    return this.props.children;
  }
}

LastData.propTypes = {
  children: React.PropTypes.element.isRequired,
  idToShow: React.PropTypes.string.isRequired,
  idShowing: React.PropTypes.string,
  loading: React.PropTypes.bool,
  fetch: React.PropTypes.func.isRequired,
};
LastData.defaultProps = {
  idShowing: null,
  loading: false,
};


export default LastData;
