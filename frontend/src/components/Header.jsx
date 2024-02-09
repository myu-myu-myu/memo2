import React, { useEffect } from 'react';
import { Outlet, useNavigate } from 'react-router-dom';
import '../App';

const Header = () => {
  const navigate = useNavigate();
  useEffect(() => {
    navigate('/personal/memo');
  }, []);
  return (
    <div className="header__component">
      <div className="header__content">
        <div>DIG Notes-test</div>
      </div>
      <Outlet />
    </div>
  );
};

export default Header;
