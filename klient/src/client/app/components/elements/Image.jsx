import React, { Component } from 'react';

import VerticalSpacer from 'elements/VerticalSpacer';
import styles from './image.less';

export class Image extends Component {

  constructor() {
    super();

    this.state = {
      isHovering: false,
    };

    this.onFocus = this.onFocus.bind(this);
    this.onBlur = this.onBlur.bind(this);
    this.onKeyDown = this.onKeyDown.bind(this);
  }

  onFocus() {
    this.setState({ isHovering: true });
  }

  onBlur() {
    this.setState({ isHovering: false });
  }

  onKeyDown(e) {
    if (e.key === 'Enter' || e.key === ' ') {
      this.props.onKeyDown();
      e.preventDefault();
    }
  }

  render() {
    return (
      <div className={styles.tooltip}>
        <img
          className={this.props.className}
          src={this.props.imageSrcFunction(this.state.isHovering)}
          alt={this.props.alt}
          tabIndex={this.props.tabIndex}
          onMouseOver={this.onFocus}
          onMouseOut={this.onBlur}
          onFocus={this.onFocus}
          onBlur={this.onBlur}
          onKeyDown={this.onKeyDown}
          onMouseDown={this.props.onMouseDown}
        />
        {this.props.tooltip !== null &&
          <div className={styles.tooltiptext}>
            <h3 className={styles.tooltipHeader}>{this.props.tooltip.header}</h3>
            <VerticalSpacer space={2} />
            <p className={styles.tooltipBody}>{this.props.tooltip.body}</p>
          </div>
        }
      </div>
    );
  }
}

Image.propTypes = {
  className: React.PropTypes.string,
  imageSrcFunction: React.PropTypes.func.isRequired,
  onMouseDown: React.PropTypes.func,
  onKeyDown: React.PropTypes.func,
  alt: React.PropTypes.string.isRequired,
  tabIndex: React.PropTypes.string,
  tooltip: React.PropTypes.shape({
    header: React.PropTypes.string.isRequired,
    body: React.PropTypes.string.isRequired,
  }),
};

Image.defaultProps = {
  className: '',
  onMouseDown: null,
  onKeyDown: null,
  tabIndex: null,
  tooltip: null,
};

export default Image;
